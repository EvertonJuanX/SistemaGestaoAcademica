package br.ifpe.edu.akadmik.gestao.Projeto.matricula;

public record DadosAtualizarMatricula( 
		Long id,
	    String numMatricula,
	    String periodoIngresso,
	    String turno
	) {
	    public DadosAtualizarMatricula(Matricula matricula) {
	        this(matricula.getId(), matricula.getNumMatricula(), matricula.getPeriodoIngresso(), matricula.getTurno());
	    }
	}

