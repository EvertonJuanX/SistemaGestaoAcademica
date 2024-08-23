package com.ifpe.gestaoalunos.matricula;

public record DadosDetalhamentoMatricula(Long id, String numMatricula, String periodoIngresso, String turno) {

	public DadosDetalhamentoMatricula(Matricula matricula) {
		this(
				matricula.getId(),
				matricula.getNumMatricula(), 
				matricula.getPeriodoIngresso(), 
				matricula.getTurno());
	}

}
