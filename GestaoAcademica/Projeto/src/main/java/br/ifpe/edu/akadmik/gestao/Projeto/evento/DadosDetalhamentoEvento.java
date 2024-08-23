package br.ifpe.edu.akadmik.gestao.Projeto.evento;

public record DadosDetalhamentoEvento(
		
		Long id,
	    String nome,
	    String local,
	    String data,
	    Boolean ativo
	    
	) {
	    public DadosDetalhamentoEvento(Evento evento) {
	        this(
	        		
	        		evento.getId(), 
	        		evento.getNome(), 
	        		evento.getLocal(), 
	        		evento.getData(), 
	        		evento.getAtivo());
	        
	    }

}