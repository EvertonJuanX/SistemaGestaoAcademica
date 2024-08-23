package com.ifpe.gestaoalunos.evento;

public record DadosListagemEvento(
		Long id,
	    String nome,
	    String local,
	    String data
	    ) {
	    public DadosListagemEvento(Evento evento) {
	        this(evento.getId(), evento.getNome(), evento.getLocal(), evento.getData());
	    }

}
