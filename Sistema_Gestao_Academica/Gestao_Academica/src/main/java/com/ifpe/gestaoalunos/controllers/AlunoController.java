package com.ifpe.gestaoalunos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.ifpe.gestaoalunos.aluno.DadosAtualizarAluno;
import com.ifpe.gestaoalunos.aluno.DadosCadastroAluno;
import com.ifpe.gestaoalunos.aluno.DadosDetalhamentoAluno;
import com.ifpe.gestaoalunos.aluno.DadosListagemAluno;
import com.ifpe.gestaoalunos.servidor.DadosAtualizarServidor;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoAluno> cadastrar(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uribuilder) {
		var aluno = new Aluno(dados);
		repository.save(aluno);
		
		var uri = uribuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));
	}
	
	@GetMapping
	public ResponseEntity<List<DadosListagemAluno>> listar(){
		var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemAluno::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoAluno> atualizar(@RequestBody @Valid DadosAtualizarAluno dados) {
		var aluno = repository.getReferenceById(dados.id());
		aluno.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
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
	public ResponseEntity<DadosDetalhamentoAluno> detalhar (@PathVariable Long id){
		var aluno = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
	}

}