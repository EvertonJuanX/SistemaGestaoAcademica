package com.ifpe.gestaoalunos.banco;

public record DadosListagemBanco(
		
		Long id,
	    String nomeBanco,
	    String numConta,
	    String agencia,
	    String operacao) {
	
	
	public DadosListagemBanco(Banco banco) {
		this(banco.getId(), banco.getNomeBanco(), banco.getNumConta(), banco.getAgencia(), banco.getOperacao());
		
			
	}

}
