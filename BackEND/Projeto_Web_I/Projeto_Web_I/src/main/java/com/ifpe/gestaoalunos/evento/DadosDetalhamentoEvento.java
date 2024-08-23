package com.ifpe.gestaoalunos.evento;

public record DadosDetalhamentoEvento(
		
		Long id,
	    String nome,
	    String local,
	    String data
	    
	) {
	    public DadosDetalhamentoEvento(Evento evento) {
	        this(
	        		
	        		evento.getId(), 
	        		evento.getNome(), 
	        		evento.getLocal(), 
	        		evento.getData());
	        
	    }

}
