package br.ifpe.edu.akadmik.gestao.Projeto.controllers;

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

import br.ifpe.edu.akadmik.gestao.Projeto.curso.Curso;
import br.ifpe.edu.akadmik.gestao.Projeto.curso.CursoRepository;
import br.ifpe.edu.akadmik.gestao.Projeto.curso.DadosAtualizarCurso;
import br.ifpe.edu.akadmik.gestao.Projeto.curso.DadosCadastroCurso;
import br.ifpe.edu.akadmik.gestao.Projeto.curso.DadosDetalhamentoCurso;
import br.ifpe.edu.akadmik.gestao.Projeto.curso.DadosListagemCurso;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoCurso> cadastrarCurso(@RequestBody @Valid DadosCadastroCurso dados,
			UriComponentsBuilder uriBuilder) {
		var curso = new Curso(dados);
		repository.save(curso);
		var uri = uriBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri();

		return ResponseEntity.created(uri).body(new DadosDetalhamentoCurso(curso));
	}

	@GetMapping
	@Transactional
	public ResponseEntity<List<DadosListagemCurso>> listar() {
		var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemCurso::new).toList();

		return ResponseEntity.ok(lista);
	}

	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoCurso> atualizar(@RequestBody @Valid DadosAtualizarCurso dados) {
		var curso = repository.getReferenceById(dados.id());
		curso.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
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
		var curso = repository.getReferenceById(id);
		curso.inativar();
		return ResponseEntity.noContent().build();
	}

	@PutMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> reativar(@PathVariable Long id) {
		var curso = repository.getReferenceById(id);
		curso.reativar();
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoCurso> detalhar(@PathVariable Long id) {
        var curso = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
    }}