package com.ifpe.gestaoalunos.evento;

public record DadosDetalhamentoEvento(
		
		Long id,
		String nome,
		String descricao,
		String data,
		String local,
		int servidor,
		int participante,
		Boolean ativo
		) {
	
	public DadosDetalhamentoEvento(Evento evento) {
		this(
				evento.getId(),
				evento.getNome(),
				evento.getDescricao(),
				evento.getData(),
				evento.getLocal(),
				evento.getServidor(),
				evento.getParticipante(),
				evento.getAtivo());
	}

}
