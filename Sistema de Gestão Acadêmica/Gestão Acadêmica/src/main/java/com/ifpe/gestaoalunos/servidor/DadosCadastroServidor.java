package com.ifpe.gestaoalunos.servidor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroServidor(
		
		@NotBlank
		String nome, 
		@NotBlank
		String siape, 
		@NotBlank
		String CPF,
		@NotBlank
		String RG, 
		
		int idade,
		@NotBlank
		String email,
		
		@NotBlank
		String cargo
		) {

}
