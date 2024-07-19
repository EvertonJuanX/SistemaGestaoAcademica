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

import com.ifpe.gestaoalunos.servidor.ServidorRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import com.ifpe.gestaoalunos.aluno.DadosListagemAluno;
import com.ifpe.gestaoalunos.servidor.DadosAtualizarServidor;
import com.ifpe.gestaoalunos.servidor.DadosCadastroServidor;
import com.ifpe.gestaoalunos.servidor.DadosDetalhamentoServidor;
import com.ifpe.gestaoalunos.servidor.DadosListagemServidor;
import com.ifpe.gestaoalunos.servidor.Servidor;

@RestController
@RequestMapping("/servidor")
public class ServidorController {
	
	@Autowired
	private ServidorRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoServidor> cadastrar(@RequestBody @Valid DadosCadastroServidor dados, UriComponentsBuilder uribuilder) {
		var servidor = new Servidor(dados);
		repository.save(servidor);
		
		var uri = uribuilder.path("/servidor/{id}").buildAndExpand(servidor.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoServidor(servidor));
	}
	
	@GetMapping
	public ResponseEntity<List<DadosListagemServidor>> listar(){
		var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemServidor::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoServidor> atualizar(@RequestBody @Valid DadosAtualizarServidor dados) {
		var servidor = repository.getReferenceById(dados.id());
		servidor.atualizarInformacoes(dados);
		
		return ResponseEntity.ok(new DadosDetalhamentoServidor(servidor));
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
		var servidor = repository.getReferenceById(id);
		servidor.inativar();
		
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> reativar(@PathVariable Long id) {
		var servidor = repository.getReferenceById(id);
		servidor.reativar();
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoServidor> detalhar(@PathVariable Long id) {
		var servidor = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhamentoServidor(servidor));
		
	}

}
