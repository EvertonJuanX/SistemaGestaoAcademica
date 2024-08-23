package com.ifpe.gestaoalunos.evento;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEvento(
		@NotBlank
		String nome,
		@NotBlank
		String descricao, 
		@NotBlank
		String data, 
		@NotBlank
		String local
		
		) {

}
