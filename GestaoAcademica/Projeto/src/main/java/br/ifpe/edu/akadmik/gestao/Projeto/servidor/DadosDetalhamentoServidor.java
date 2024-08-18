package br.ifpe.edu.akadmik.gestao.Projeto.servidor;

public record DadosDetalhamentoServidor(
	    Long id,
	    String siepe,
	    String cargo,
	    Long idUsuario
	) {
	    public DadosDetalhamentoServidor(Servidor servidor) {
	        this(servidor.getId(), servidor.getSiepe(), servidor.getCargo(), servidor.getIdUsuario());
	    }

}
