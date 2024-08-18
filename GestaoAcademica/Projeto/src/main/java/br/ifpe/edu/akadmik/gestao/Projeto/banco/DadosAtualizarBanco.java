package br.ifpe.edu.akadmik.gestao.Projeto.banco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarBanco(	
		
		
		@NotNull
		Long id,
	    String nomeBanco,
	    String numConta,
	    String agencia,
	    String operacao) {

	  
}
