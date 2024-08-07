package com.ifpe.gestaoalunos.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(
		
		@NotNull
		Long id,
		String nome,
		String email,
		String telefone

		) {

}
