package br.edu.ifpe.gestaoacademica.model;

public class Matricula {
	private Long id;
	private String numMatricula;
	private String periodoIngresso;
	private String turno;
	
	//FOREING KEYS
	private Aluno aluno;
	private Curso curso;
}
