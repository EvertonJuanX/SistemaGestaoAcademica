package com.ifpe.gestaoalunos.banco;

public record DadosDetalhamentoBanco(
		
		Long id,
	    String nomeBanco,
	    String numConta,
	    String agencia,
	    String operacao) {
	
	
	public DadosDetalhamentoBanco(Banco banco) {
		this(banco.getId(), banco.getNomeBanco(), banco.getNumConta(), banco.getAgencia(), banco.getOperacao());
		
			
	}
}
