package br.ifpe.edu.akadmik.gestao.Projeto.matricula;

public record DadosListagemMatricula(

		Long id, String numMatricula, String periodoIngresso, String turno) {
	
	
	public DadosListagemMatricula(Matricula matricula) {
		this(
				
				matricula.getId(), 
				matricula.getNumMatricula(), 
				matricula.getPeriodoIngresso(), 
				matricula.getTurno());
	}
}
