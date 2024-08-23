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

import com.ifpe.gestaoalunos.evento.DadosAtualizarEvento;
import com.ifpe.gestaoalunos.evento.DadosCadastroEvento;
import com.ifpe.gestaoalunos.evento.DadosDetalhamentoEvento;
import com.ifpe.gestaoalunos.evento.DadosListagemEvento;
import com.ifpe.gestaoalunos.evento.Evento;
import com.ifpe.gestaoalunos.evento.EventoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

//@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
    private EventoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoEvento> cadastrarEvento(@RequestBody @Valid DadosCadastroEvento dados, UriComponentsBuilder uriBuilder) {
        var evento = new Evento(dados);
        repository.save(evento);
        var uri = uriBuilder.path("/evento/{id}").buildAndExpand(evento.getId()).toUri();
        
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEvento(evento));
    }/*

    @GetMapping
    @Transactional
    public ResponseEntity<List<DadosListagemEvento>> listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemEvento::new).toList();
        
        return ResponseEntity.ok(lista);
    }*/

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoEvento> atualizar(@RequestBody @Valid DadosAtualizarEvento dados) {
        var evento = repository.getReferenceById(dados.id());
        evento.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoEvento(evento));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
/*
    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        var evento = repository.getReferenceById(id);
        evento.inativar();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id) {
        var evento = repository.getReferenceById(id);
        evento.reativar();
        return ResponseEntity.noContent().build();
    }
*/
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoEvento> detalhar(@PathVariable Long id) {
        var evento = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoEvento(evento));
    }
}
