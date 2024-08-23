package br.ifpe.edu.akadmik.gestao.Projeto.aluno;

import java.util.List;

import br.ifpe.edu.akadmik.gestao.Projeto.matricula.Matricula;
import br.ifpe.edu.akadmik.gestao.Projeto.usuario.Usuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
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
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "idUsuario", referencedColumnName = "id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "aluno")
	private List<Matricula> matricula;
}	
