package com.ifpe.gestaoalunos.aluno;

public record DadosListagemAluno(
		Long id
		) 	

{
	
	public DadosListagemAluno(Aluno aluno) {
    this(aluno.getId());
}
}