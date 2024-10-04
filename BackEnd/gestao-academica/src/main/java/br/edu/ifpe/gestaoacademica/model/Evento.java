package br.edu.ifpe.gestaoacademica.model;

import java.time.LocalDate;

public class Evento {
	private Long id;
	private String nome;
	private String descricao;
	private LocalDate data;
	private String local;
	private String tipo;
	
	//FOREING KEYS
	private Servidor servidor;
	private LocalEvento localEvento;   
}
