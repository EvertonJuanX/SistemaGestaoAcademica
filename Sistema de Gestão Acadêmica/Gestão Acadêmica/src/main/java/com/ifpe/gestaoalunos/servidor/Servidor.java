package com.ifpe.gestaoalunos.servidor;

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


@Table(name = "Servidor")
@Entity(name = "servidores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Servidor {
	
	public Servidor(DadosCadastroServidor dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.siape = dados.siape();
		this.CPF = dados.CPF();
		this.RG = dados.RG();
		this.idade = dados.idade();
		this.email = dados.email();
		this.cargo = dados.cargo();
		
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome; 
	private String siape; 
	private String CPF;
	private String RG;
	private int idade;
	private String email;
	private Boolean ativo;
	private String cargo;
	
	public void atualizarInformacoes(@Valid DadosAtualizarServidor dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.siape() != null) {
			this.siape = dados.siape();
		}
		if (dados.CPF() != null) {
			this.CPF = dados.CPF();
		}
		if (dados.RG() != null) {
			this.RG = dados.RG();
		}
		if (dados.email() != null) {
			this.email = dados.email();
		}
		
		if (dados.cargo() != null) {
			this.cargo = dados.cargo();
		}
		
	}

	public void inativar() {
		this.ativo = false;
		
	}

	public void reativar() {
		this.ativo = true;
		
	}

}
