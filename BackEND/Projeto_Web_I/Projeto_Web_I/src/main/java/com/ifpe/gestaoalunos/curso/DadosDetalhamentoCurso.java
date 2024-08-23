package com.ifpe.gestaoalunos.curso;

public record DadosDetalhamentoCurso(
		Long id,
		String nomeCurso, 	
		String nivel,
		Boolean ativo
) {
	public DadosDetalhamentoCurso(Curso curso){
		this(curso.getId(), 
				curso.getNomeCurso(),
				curso.getNivel()
				,curso.getAtivo());
	}
}
