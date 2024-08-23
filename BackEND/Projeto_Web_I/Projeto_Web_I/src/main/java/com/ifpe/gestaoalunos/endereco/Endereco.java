package com.ifpe.gestaoalunos.endereco;

import java.util.List;

import com.ifpe.gestaoalunos.servidor.DadosCadastroServidor;
import com.ifpe.gestaoalunos.usuario.DadosCadastroUsuario;
import com.ifpe.gestaoalunos.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Endereco")
@Entity(name = "endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Estados estado;
	private String cidade;
	private String cep;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;
	private Boolean ativo;

	@OneToMany(mappedBy = "endereco")
	private List<Usuario> usuario;

	public Endereco(DadosCadastroUsuario dados) {
		this.estado = dados.estado();
		this.cidade = dados.cidade();
		this.cep = dados.cep();
		this.bairro = dados.bairro();
		this.rua = dados.rua();
		this.numero = dados.numero();
		this.complemento = dados.complemento();
		this.ativo = true;

	}
	
	public Endereco(DadosCadastroServidor dados) {
		this.estado = dados.estado();
		this.cidade = dados.cidade();
		this.cep = dados.cep();
		this.bairro = dados.bairro();
		this.rua = dados.rua();
		this.numero = dados.numero();
		this.complemento = dados.complemento();
		this.ativo = true;

	}

	public void atualizarInformacoes(@Valid DadosAtualizarEndereco dados) {
		if (dados.estado() != null) {
			this.estado = dados.estado();
		}
		if (dados.cidade() != null){
			this.cidade = dados.cidade();
		}
		if (dados.cep() != null) {
			this.cep = dados.cep();
		}
		if (dados.bairro() != null) {
			this.bairro = dados.bairro();
		}
		if (dados.rua() != null) {
			this.rua = dados.rua();
		}
		if (dados.numero() != null) {
			this.numero = dados.numero();
		}
		if (dados.complemento() != null) {
			this.complemento = dados.complemento();
		}

	}

	public void inativar() {
		this.ativo = false;

	}

	public void reativar() {
		this.ativo = true;

	}

}