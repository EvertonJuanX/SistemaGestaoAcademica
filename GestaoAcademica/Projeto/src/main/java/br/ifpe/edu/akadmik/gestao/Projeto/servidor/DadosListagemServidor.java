package br.ifpe.edu.akadmik.gestao.Projeto.servidor;

public record DadosListagemServidor(
	    Long id,
	    String siepe,
	    String cargo
	) {
	    public DadosListagemServidor(Servidor servidor) {
	        this(servidor.getId(), servidor.getSiepe(), servidor.getCargo());
	    }
}
