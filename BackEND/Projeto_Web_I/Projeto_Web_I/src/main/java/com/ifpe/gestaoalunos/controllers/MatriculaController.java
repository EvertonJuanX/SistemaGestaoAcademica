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
import org.springframework.web.util.UriComponentsBuilder;

import com.ifpe.gestaoalunos.matricula.DadosAtualizarMatricula;
import com.ifpe.gestaoalunos.matricula.DadosCadastroMatricula;
import com.ifpe.gestaoalunos.matricula.DadosDetalhamentoMatricula;
import com.ifpe.gestaoalunos.matricula.DadosListagemMatricula;
import com.ifpe.gestaoalunos.matricula.Matricula;
import com.ifpe.gestaoalunos.matricula.MatriculaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")


public class MatriculaController {
	
	@Autowired
    private MatriculaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoMatricula> cadastrarMatricula(@RequestBody @Valid DadosCadastroMatricula dados, UriComponentsBuilder uriBuilder) {
        var matricula = new Matricula(dados);
        repository.save(matricula);
        var uri = uriBuilder.path("/matricula/{id}").buildAndExpand(matricula.getId()).toUri();
        
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMatricula(matricula));
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<DadosListagemMatricula>> listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemMatricula::new).toList();
        
        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoMatricula> atualizar(@RequestBody @Valid DadosAtualizarMatricula dados) {
        var matricula = repository.getReferenceById(dados.id());
        matricula.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMatricula(matricula));
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
        var matricula = repository.getReferenceById(id);
        matricula.inativar();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id) {
        var matricula = repository.getReferenceById(id);
        matricula.reativar();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoMatricula> detalhar(@PathVariable Long id) {
        var matricula = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMatricula(matricula));
    }
}
