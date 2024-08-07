package com.ifpe.gestaoalunos.usuario;


import java.time.LocalDate;
import java.util.List;

import br.ifpe.edu.akadmik.gestao.Projeto.aluno.Aluno;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Usuario")
@Entity(name = "usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

@EqualsAndHashCode(of = "id")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String cpf;
	private String rg;
	private LocalDate dataNascimento;
	private String telefone;
	private String email;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	private Boolean ativo;
	
	@OneToMany(mappedBy = "usuario")
	private List<Aluno> alunos;
	
	public Usuario(DadosCadastroUsuario dados) {
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.rg = dados.rg();
		this.dataNascimento = dados.dataNascimento();
		this.telefone = dados.telefone();
		this.email = dados.email();
		this.sexo = dados.sexo();
		this.ativo= true;
	}

	public void atualizarInformacoes(@Valid DadosAtualizarUsuario dados) {
		if (dados.email() != null) {
			this.email = dados.email();
		}
		if (dados.telefone() != null) {
			this.telefone = dados.telefone();

		}
		if (dados.nome() != null) {
			this.nome = dados.nome();

		}
	}

	public void inativar() {
		this.ativo=false;
	}

	public void reativar() {
		this.ativo=true;
	}
}