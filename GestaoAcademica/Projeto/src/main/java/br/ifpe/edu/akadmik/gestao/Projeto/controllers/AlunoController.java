package br.ifpe.edu.akadmik.gestao.Projeto.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ifpe.edu.akadmik.gestao.Projeto.aluno.DadosCadastroAluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@PostMapping
	public void cadastrarAluno(@RequestBody DadosCadastroAluno dados) {
		
		System.out.println(dados);
		
	}
	
	
	
}
