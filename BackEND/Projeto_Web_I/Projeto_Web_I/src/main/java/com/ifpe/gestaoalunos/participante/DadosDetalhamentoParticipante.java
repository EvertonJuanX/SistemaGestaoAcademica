package com.ifpe.gestaoalunos.participante;

public record DadosDetalhamentoParticipante(
	    Long id
	    
	) {
	    public DadosDetalhamentoParticipante(Participante participante) {
	        this(participante.getId());
	    }

}
