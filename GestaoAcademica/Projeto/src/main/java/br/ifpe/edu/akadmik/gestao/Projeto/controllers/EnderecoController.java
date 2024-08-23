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

import br.ifpe.edu.akadmik.gestao.Projeto.endereco.DadosAtualizarEndereco;
import br.ifpe.edu.akadmik.gestao.Projeto.endereco.DadosCadastroEndereco;
import br.ifpe.edu.akadmik.gestao.Projeto.endereco.DadosDetalhamentoEndereco;
import br.ifpe.edu.akadmik.gestao.Projeto.endereco.DadosListagemEndereco;
import br.ifpe.edu.akadmik.gestao.Projeto.endereco.Endereco;
import br.ifpe.edu.akadmik.gestao.Projeto.endereco.EnderecoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoEndereco> CadastrarEndereco(@RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriBuilder) {
		var endereco = new Endereco(dados);
		repository.save(endereco);
		var uri = uriBuilder.path("/endereco/{id}").buildAndExpand(endereco.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(endereco));
	}
	
		
	@GetMapping
	@Transactional
	public ResponseEntity<List<DadosListagemEndereco>> listar() {
		var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemEndereco::new).toList();
		
		return ResponseEntity.ok(lista);

		
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoEndereco> Atualizar(@RequestBody @Valid DadosAtualizarEndereco dados) {
		var endereco = repository.getReferenceById(dados.id());
		endereco.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));

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
		var endereco = repository.getReferenceById(id);
		endereco.inativar();
		return ResponseEntity.noContent().build();
	}

	@PutMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> Reativar(@PathVariable Long id) {
		var endereco = repository.getReferenceById(id);
		endereco.reativar();
		return ResponseEntity.noContent().build();

	}

	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoEndereco> Detalhar(@PathVariable Long id) {
		var endereco = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
				}
	

	
}