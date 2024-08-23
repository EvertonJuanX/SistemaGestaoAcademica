package com.ifpe.gestaoalunos.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCurso(
		
		@NotBlank 
		String nomeCurso, 
		String nivel) {

}
