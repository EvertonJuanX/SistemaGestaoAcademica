package com.ifpe.gestaoalunos.aluno;

public record DadosDetalhamentoAluno(
		Long id		) 	

{
	
	public DadosDetalhamentoAluno(Aluno aluno) {
    this(aluno.getId());
}
}
