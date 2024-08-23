package com.ifpe.gestaoalunos.aluno;

public record DadosAtualizarAluno(
		Long id
		) 	

{
	
	public DadosAtualizarAluno(Aluno aluno) {
    this(aluno.getId());
}
}