package br.ifpe.edu.akadmik.gestao.Projeto.participante;

public record DadosListagemParticipante(
	    Long id
	) {
	    public DadosListagemParticipante(Participante participante) {
	        this(participante.getId());
	    }

}
