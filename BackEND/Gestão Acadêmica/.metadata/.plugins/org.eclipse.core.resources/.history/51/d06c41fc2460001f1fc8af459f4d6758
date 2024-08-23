package com.ifpe.gestaoalunos.aluno;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "Aluno")
@Entity(name = "alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Aluno {
	
	public Aluno(DadosCadastroAluno dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.matricula = dados.matricula();
		this.curso = dados.curso();
		this.periodo = dados.periodo();
		this.idade = dados.idade();
		this.email = dados.email();
		this.CPF = dados.CPF();
		
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome; 
	private String matricula; 
	private String curso;
	private String periodo;
	private int idade;
	private String email;
	private String CPF;
	private Boolean ativo;
	
	public void atualizarInformacoes(@Valid DadosAtualizarAluno dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.matricula() != null) {
			this.matricula = dados.matricula();
		}
		if (dados.curso() != null) {
			this.curso = dados.curso();
		}
		if (dados.periodo() != null) {
			this.periodo = dados.periodo();
		}
		if (dados.email() != null) {
			this.email = dados.email();
		}
		if (dados.CPF() != null) {
			this.CPF = dados.CPF();
		}
	}

	public void inativar() {
		this.ativo = false;
		
	}

	public void reativar() {
		this.ativo = true;
		
	}

}
