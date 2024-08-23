package com.ifpe.gestaoalunos.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEndereco(

		
		Long id,

		Estados estado, 
		
		@NotBlank
		String cidade,
		
		@NotBlank
		String cep, 
		
		@NotBlank
		String bairro, 
		
		@NotBlank
		String rua, 
		
		@NotBlank
		String numero, 
		
		@NotBlank
		String complemento
		


) {

}
