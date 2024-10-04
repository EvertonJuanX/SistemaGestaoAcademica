package br.edu.ifpe.gestaoacademica.model;

public class Participante {
	private Long id;
	
	//FOREING KEYS
	private Usuario usuario;
	private Evento evento;
	private Certificado certificado;
}
