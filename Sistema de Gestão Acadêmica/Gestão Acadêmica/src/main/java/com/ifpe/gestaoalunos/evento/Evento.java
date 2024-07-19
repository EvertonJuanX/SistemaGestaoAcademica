package com.ifpe.gestaoalunos.evento;

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


@Table(name = "Disciplina")
@Entity(name = "disciplinas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Evento {
	
	public Evento(DadosCadastroEvento dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.descricao = dados.descricao();
		this.data = dados.data();
		this.local = dados.local();
		this.servidor = dados.servidor();
		this.participante = dados.participante();
				
	}
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descricao;
	private String data; 
	private String local; 
	private int servidor;
	private int participante;
	private Boolean ativo;
	
	public void atualizarInformacoes(@Valid DadosAtualizarEvento dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.descricao() != null) {
			this.descricao = dados.descricao();
		}
		if (dados.data() != null) {
			this.data = dados.data();
		}
		if (dados.local() != null) {
			this.local = dados.local();
		}
		
	}
	
	public void inativar() {
		this.ativo = false;
		
	}

	public void reativar() {
		this.ativo = true;
		
	}

}
