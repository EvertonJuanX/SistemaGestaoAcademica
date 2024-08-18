package br.ifpe.edu.akadmik.gestao.Projeto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifpe.edu.akadmik.gestao.Projeto.administrador.Administrador;
import br.ifpe.edu.akadmik.gestao.Projeto.administrador.DadosAutenticacao;
import br.ifpe.edu.akadmik.gestao.Projeto.infrar.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")

public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var autenticacao = manager.authenticate(token);

		return ResponseEntity.ok(tokenService.gerarToken((Administrador) autenticacao.getPrincipal()));
	}
}
