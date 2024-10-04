package br.edu.ifpe.gestaoacademica.model;

import java.time.LocalDate;

public class Usuario {
	private Long id;
	private String nome;
	private String cpf;
	private String rg;
	private LocalDate dataNasc;
	private String telefone;
	private String email;
	
	//FOREING KEYS
	private Endereco endereco;
	private Banco banco;
}
