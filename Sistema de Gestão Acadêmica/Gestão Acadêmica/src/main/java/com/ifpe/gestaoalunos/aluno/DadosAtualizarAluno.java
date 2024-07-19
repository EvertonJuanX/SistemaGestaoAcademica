package com.ifpe.gestaoalunos.aluno;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAluno(
		
		@NotNull
		Long id,
		String nome, 
		String matricula, 
		String curso, 
		String periodo,  
		String email, 
		String CPF) {

}
