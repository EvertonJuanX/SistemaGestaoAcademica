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

import br.ifpe.edu.akadmik.gestao.Projeto.usuario.DadosAtualizarUsuario;
import br.ifpe.edu.akadmik.gestao.Projeto.usuario.DadosCadastroUsuario;
import br.ifpe.edu.akadmik.gestao.Projeto.usuario.DadosDetalhamentoUsuario;
import br.ifpe.edu.akadmik.gestao.Projeto.usuario.DadosListagemUsuario;
import br.ifpe.edu.akadmik.gestao.Projeto.usuario.Usuario;
import br.ifpe.edu.akadmik.gestao.Projeto.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoUsuario> CadastrarUsuario(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
		var usuario = new Usuario(dados);
		repository.save(usuario);
		var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
	}
	
		
	@GetMapping
	@Transactional
	public ResponseEntity<List<DadosListagemUsuario>> listar() {
		var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemUsuario::new).toList();
		
		return ResponseEntity.ok(lista);

		
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhamentoUsuario> Atualizar(@RequestBody @Valid DadosAtualizarUsuario dados) {
		var usuario = repository.getReferenceById(dados.id());
		usuario.atualizarInformacoes(dados);
		return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));

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
		var usuario = repository.getReferenceById(id);
		usuario.inativar();
		return ResponseEntity.noContent().build();
	}

	@PutMapping("reativar/{id}")
	@Transactional
	public ResponseEntity<Void> Reativar(@PathVariable Long id) {
		var usuario = repository.getReferenceById(id);
		usuario.reativar();
		return ResponseEntity.noContent().build();

	}

	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhamentoUsuario> Detalhar(@PathVariable Long id) {
		var usuario = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
				}
	

	
	
}
