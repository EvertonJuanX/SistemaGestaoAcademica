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
		
		
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private Boolean ativo;
	
	public void atualizarInformacoes(@Valid DadosAtualizarAluno dados) {
		
	}

	public void inativar() {
		this.ativo = false;
		
	}

	public void reativar() {
		this.ativo = true;
		
	}

}
