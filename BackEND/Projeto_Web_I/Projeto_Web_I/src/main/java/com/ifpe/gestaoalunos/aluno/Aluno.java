package com.ifpe.gestaoalunos.aluno;

import java.util.List;

import com.ifpe.gestaoalunos.matricula.Matricula;
import com.ifpe.gestaoalunos.usuario.DadosCadastroUsuario;
import com.ifpe.gestaoalunos.usuario.Usuario;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name= "aluno")
@DiscriminatorValue("Aluno")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Aluno extends Usuario{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ID próprio de Aluno
	
//	@ManyToOne
//	@JoinColumn(name = "idUsuario", referencedColumnName = "id")
//	private Usuario usuario;
	
	@OneToMany(mappedBy = "aluno")
	private List<Matricula> matricula;
	
	

    public void inativar() {
        super.inativar(); 
    }

    public void reativar() {
        super.reativar(); // Chama o método reativar da classe pai Usuario
    }

	public Aluno(DadosCadastroUsuario dados) {
		super(dados);
	}
}	
