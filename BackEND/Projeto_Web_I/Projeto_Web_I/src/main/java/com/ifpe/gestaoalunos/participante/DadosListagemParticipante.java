package com.ifpe.gestaoalunos.participante;

public record DadosListagemParticipante(
	    Long id
	) {
	    public DadosListagemParticipante(Participante participante) {
	        this(participante.getId());
	    }

}
