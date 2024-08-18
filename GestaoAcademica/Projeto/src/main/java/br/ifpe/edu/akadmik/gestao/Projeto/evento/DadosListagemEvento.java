package br.ifpe.edu.akadmik.gestao.Projeto.evento;

public record DadosListagemEvento(
		Long id,
	    String nome,
	    String local,
	    String data,
	    Boolean ativo
	) {
	    public DadosListagemEvento(Evento evento) {
	        this(evento.getId(), evento.getNome(), evento.getLocal(), evento.getData(), evento.getAtivo());
	    }

}
