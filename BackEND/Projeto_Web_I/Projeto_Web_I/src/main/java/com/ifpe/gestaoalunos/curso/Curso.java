package com.ifpe.gestaoalunos.curso;

import java.util.List;

import com.ifpe.gestaoalunos.matricula.Matricula;
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

@Table(name="Curso")
@Entity(name="curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")


public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeCurso;
	private String nivel;
	private Boolean ativo;
	
	@OneToMany(mappedBy = "curso")
	private List<Matricula> matricula;
	
	public Curso(DadosCadastroCurso dados) {
        this.nomeCurso = dados.nomeCurso();
        this.nivel = dados.nivel();
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizarCurso dados) {
        if (dados.nomeCurso() != null) {
            this.nomeCurso = dados.nomeCurso();
        }
        if (dados.nivel() != null) {
            this.nivel = dados.nivel();
        }
    }

    public void inativar() {
        this.ativo = false;
    }

    public void reativar() {
        this.ativo = true;
    }
}

