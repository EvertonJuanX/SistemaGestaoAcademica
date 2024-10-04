package br.edu.ifpe.gestaoacademica.model;

public class Avaliacao {
	private Long id;
	private String nota;
	
	//FOREING KEYS
	private Evento evento;
	private Participante participante;
}
