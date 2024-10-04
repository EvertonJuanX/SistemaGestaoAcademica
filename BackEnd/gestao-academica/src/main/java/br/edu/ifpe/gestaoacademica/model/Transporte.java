package br.edu.ifpe.gestaoacademica.model;

import java.time.LocalDate;

public class Transporte {
	private Long id;
	private String tipo;
	private String placa;
	private String nomeMotorista;
	private String cpfMotorista;
	private LocalDate horaSaida;
	private LocalDate horaChegada;
	private float quilometragem;
	
	//FOREING KEYS
	private Evento evento;
	private Servidor responsavel;
	private Participante participantes;
}
