package com.ifpe.gestaoalunos.servidor;

public record DadosDetalhamentoServidor(
	    Long id,
	    String siepe,
	    String cargo
	) {
	    public DadosDetalhamentoServidor(Servidor servidor) {
	        this(servidor.getId(), servidor.getSiepe(), servidor.getCargo());
	    }

}
