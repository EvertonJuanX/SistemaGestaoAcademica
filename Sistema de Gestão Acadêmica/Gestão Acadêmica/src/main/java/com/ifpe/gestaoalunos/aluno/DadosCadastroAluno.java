package com.ifpe.gestaoalunos.aluno;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAluno(
		
		@NotBlank
		String nome,
		@NotBlank
		String matricula, 
		@NotBlank
		String curso, 
		@NotBlank
		String periodo, 
		
		int idade, 
		@NotBlank
		String email, 
		@NotBlank
		String CPF) {

}
