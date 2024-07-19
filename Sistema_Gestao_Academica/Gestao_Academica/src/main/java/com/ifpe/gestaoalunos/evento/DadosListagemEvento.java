package com.ifpe.gestaoalunos.evento;

public record DadosListagemEvento(Long id,String nome, String descricao, String data, String local, int servidor) {
	
	public DadosListagemEvento(Evento evento) {
		this(evento.getId(),evento.getNome(),evento.getDescricao(),evento.getData(),evento.getLocal(),evento.getServidor());
	}

}
