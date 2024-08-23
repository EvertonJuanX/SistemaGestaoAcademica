package com.ifpe.gestaoalunos.participante;

import com.ifpe.gestaoalunos.evento.Evento;
import com.ifpe.gestaoalunos.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Participante")
@Entity(name = "participante")

@Getter
@Setter

@EqualsAndHashCode(of = "id")
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "idUsuario", referencedColumnName = "id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "idEvento", referencedColumnName= "id")
	private Evento evento;
	
	
	
	

	public Participante(DadosCadastroParticipante dados) {
		
			}

	public void atualizarInformacoes(DadosAtualizarParticipante dados) {
		
			}
	}


