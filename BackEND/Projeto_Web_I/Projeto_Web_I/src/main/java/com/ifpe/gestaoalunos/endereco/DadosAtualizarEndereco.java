package com.ifpe.gestaoalunos.endereco;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarEndereco(
		
		
		@NotNull
		Long id,
		
		@Enumerated
		Estados estado,
		String cidade,
		String cep,
		String bairro,
		String rua,
		String numero,
		String complemento,
		Boolean ativo
		
		
		
		
		) {

}
