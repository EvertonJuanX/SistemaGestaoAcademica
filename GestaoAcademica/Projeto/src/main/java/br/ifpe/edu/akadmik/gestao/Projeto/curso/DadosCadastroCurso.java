package br.ifpe.edu.akadmik.gestao.Projeto.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCurso(
		
		@NotBlank 
		String nomeCurso, 
		String nivel) {

}
