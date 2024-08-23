package com.ifpe.gestaoalunos.banco;

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

@Table(name="Banco")
@Entity(name="banco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Banco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeBanco;
	private String numConta;
	private String agencia;
	private String operacao;
	private Boolean ativo;
	
	
	@OneToMany(mappedBy = "banco")
	private List<Usuario> usuario;
	
	
	
	public Banco(@Valid DadosCadastroUsuario dados) {
		this.nomeBanco = dados.nomeBanco();
        this.numConta = dados.numConta();
        this.agencia = dados.agencia();
        this.operacao = dados.operacao();
		this.ativo = true;

	}
	
	public Banco(DadosCadastroServidor dados) {
		this.nomeBanco = dados.nomeBanco();
        this.numConta = dados.numConta();
        this.agencia = dados.agencia();
        this.operacao = dados.operacao();
		this.ativo = true;

	}
	
	public void atualizarInformacoes(@Valid DadosAtualizarBanco dados) {
        if (dados.nomeBanco() != null) {
            this.nomeBanco = dados.nomeBanco();
        }
        if (dados.numConta() != null) {
            this.numConta = dados.numConta();
        }
        if (dados.agencia() != null) {
            this.agencia = dados.agencia();
        }
        if (dados.operacao() != null) {
            this.operacao = dados.operacao();
        }
    }
	public void inativar() {
		this.ativo = false;
	}

	public void reativar() {
		this.ativo = true;
	}
}
