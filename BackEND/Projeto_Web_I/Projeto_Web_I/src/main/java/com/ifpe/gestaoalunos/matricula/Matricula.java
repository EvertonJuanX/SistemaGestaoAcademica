package com.ifpe.gestaoalunos.matricula;
import com.ifpe.gestaoalunos.aluno.Aluno;
import com.ifpe.gestaoalunos.curso.Curso;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Matricula")
@Entity(name="matricula")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numMatricula;
	private String periodoIngresso;
	private String turno;
	private Boolean ativo;
	
		
	@ManyToOne
	@JoinColumn(name = "idAluno", referencedColumnName = "id")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "idCurso", referencedColumnName = "id")
	private Curso curso;
	
    public Matricula(DadosCadastroMatricula dados) {
        this.numMatricula = dados.numMatricula();
        this.periodoIngresso = dados.periodoIngresso();
        this.turno = dados.turno();
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizarMatricula dados) {
        if (dados.numMatricula() != null) {
            this.numMatricula = dados.numMatricula();
        }
        if (dados.periodoIngresso() != null) {
            this.periodoIngresso = dados.periodoIngresso();
        }
        if (dados.turno() != null) {
            this.turno = dados.turno();
        }
    }
	
	public void inativar() {
		this.ativo = false;
	}

	public void reativar() {
		this.ativo = true;
	}
}
