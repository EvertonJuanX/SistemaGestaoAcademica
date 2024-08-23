package com.ifpe.gestaoalunos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ifpe.gestaoalunos.aluno.Aluno;
import com.ifpe.gestaoalunos.aluno.AlunoRepository;
import com.ifpe.gestaoalunos.aluno.DadosCadastroAluno;
import com.ifpe.gestaoalunos.aluno.DadosDetalhamentoAluno;
import com.ifpe.gestaoalunos.aluno.DadosListagemAluno;
import com.ifpe.gestaoalunos.banco.Banco;
import com.ifpe.gestaoalunos.banco.BancoRepository;
import com.ifpe.gestaoalunos.endereco.DadosListagemEndereco;
import com.ifpe.gestaoalunos.endereco.Endereco;
import com.ifpe.gestaoalunos.endereco.EnderecoRepository;
import com.ifpe.gestaoalunos.usuario.DadosCadastroUsuario;
import com.ifpe.gestaoalunos.usuario.DadosDetalhamentoUsuario;
import com.ifpe.gestaoalunos.usuario.DadosListagemUsuario;
import com.ifpe.gestaoalunos.usuario.Usuario;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private BancoRepository bancoRepository;
    @Autowired
    private AlunoRepository repository;
    @PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoUsuario> CadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
		Aluno aluno = new Aluno(dados);
		Endereco endereco = new Endereco(dados);
		Banco banco = new Banco(dados);
		
		banco.setUsuario(List.of(aluno));
		endereco.setUsuario(List.of(aluno));
		
		aluno.setBanco(banco);
		aluno.setEndereco(endereco);
		//Endereco endereco= enderecoRepository.getById(dados.e());
		//usuario.setEndereco(endereco);
		enderecoRepository.save(endereco);
		bancoRepository.save(banco);
		repository.save(aluno);
	
		var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(aluno.getId()).toUri();
		
		
		
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(aluno));
	}

//    @PostMapping
//    @Transactional
//    public ResponseEntity<DadosCadastroAluno> cadastrarAluno(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uriBuilder) {
//        var aluno = new Aluno();
//        repository.save(aluno);
//        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
//        
//        return ResponseEntity.created(uri).body(new DadosCadastroAluno());
//    }
/*
    @GetMapping
    @Transactional
    public ResponseEntity<List<DadosListagemAluno>> listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemAluno::new).toList();
        return ResponseEntity.ok(lista);
    }
    */
    @GetMapping
    @Transactional
    public ResponseEntity<List<DadosListagemUsuario>> listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemUsuario::new).toList();

        return ResponseEntity.ok(lista);
    }

 

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        var aluno = repository.getReferenceById(id);
        aluno.inativar();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id) {
        var aluno = repository.getReferenceById(id);
        aluno.reativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoAluno> detalhar(@PathVariable Long id) {
        var aluno = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }
}
