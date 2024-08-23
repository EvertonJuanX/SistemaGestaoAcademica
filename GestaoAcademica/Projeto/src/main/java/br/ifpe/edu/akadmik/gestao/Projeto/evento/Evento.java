package br.ifpe.edu.akadmik.gestao.Projeto.evento;

import java.util.List;

import br.ifpe.edu.akadmik.gestao.Projeto.participante.Participante;
import br.ifpe.edu.akadmik.gestao.Projeto.servidor.Servidor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Evento")
@Entity(name = "evento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Evento {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private String data; 
	private String local; 
	private Boolean ativo;
	
	
	
	@ManyToOne
	@JoinColumn(name = "idServidor", referencedColumnName ="id")
	private Servidor servidor ;
	
	
	@OneToMany(mappedBy = "evento")
	private List<Participante> participante;
	
	
	public Evento(DadosCadastroEvento dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.descricao = dados.descricao();
		this.data = dados.data();
		this.local = dados.local();
				
	}
	
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