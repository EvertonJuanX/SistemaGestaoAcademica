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

import com.ifpe.gestaoalunos.banco.Banco;
import com.ifpe.gestaoalunos.banco.BancoRepository;
import com.ifpe.gestaoalunos.banco.DadosAtualizarBanco;
import com.ifpe.gestaoalunos.banco.DadosCadastroBanco;
import com.ifpe.gestaoalunos.banco.DadosDetalhamentoBanco;
import com.ifpe.gestaoalunos.banco.DadosListagemBanco;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/banco")

public class BancoController {

	@Autowired
	private BancoRepository repository;

	/*
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoBanco> CadastrarBanco(@RequestBody @Valid DadosCadastroBanco dados, UriComponentsBuilder uriBuilder) {
		var banco = new Banco(dados);
		repository.save(banco);
		var uri = uriBuilder.path("/banco/{id}").buildAndExpand(banco.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoBanco(banco));
	}*/
	
	@GetMapping
	@Transactional
	public ResponseEntity<List<DadosListagemBanco>> listar() {
		var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemBanco::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoBanco> Atualizar(@RequestBody @Valid DadosAtualizarBanco dados) {
		var banco = repository.getReferenceById(dados.id());
		banco.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosDetalhamentoBanco(banco));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> Excluir(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("inativar/{id}")
	@Transactional
	public ResponseEntity<Void> Inativar(@PathVariable Long id) {
		var banco = repository.getReferenceById(id);
		banco.inativar();
		return ResponseEntity.noContent().build();
	}

	@PutMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> Reativar(@PathVariable Long id) {
		var banco = repository.getReferenceById(id);
		banco.reativar();
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoBanco> Detalhar(@PathVariable Long id) {
		var banco = repository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoBanco(banco));
	}
}
