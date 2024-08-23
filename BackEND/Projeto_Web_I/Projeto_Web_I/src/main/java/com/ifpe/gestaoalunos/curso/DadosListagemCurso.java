package com.ifpe.gestaoalunos.curso;

public record DadosListagemCurso(
		Long id,
		String nomeCurso, 	
		String nivel,
		Boolean ativo
) {
	public DadosListagemCurso(Curso curso){
		this(curso.getId(), 
				curso.getNomeCurso(),
				curso.getNivel()
				,curso.getAtivo());
	}
}
