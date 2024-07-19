package com.ifpe.gestaoalunos.servidor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarServidor(
		
		@NotNull
		Long id,
		String nome, 
		String siape, 
		String CPF, 
		String RG, 
		String email,
		String cargo) {

}
