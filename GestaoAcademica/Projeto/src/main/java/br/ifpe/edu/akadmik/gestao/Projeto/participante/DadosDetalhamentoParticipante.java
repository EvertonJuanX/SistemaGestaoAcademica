package br.ifpe.edu.akadmik.gestao.Projeto.participante;

public record DadosDetalhamentoParticipante(
	    Long id
	    
	) {
	    public DadosDetalhamentoParticipante(Participante participante) {
	        this(participante.getId());
	    }

}
