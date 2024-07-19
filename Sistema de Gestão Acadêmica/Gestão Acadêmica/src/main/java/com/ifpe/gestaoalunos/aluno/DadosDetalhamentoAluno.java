package com.ifpe.gestaoalunos.aluno;

public record DadosDetalhamentoAluno(
		
		Long id,
		String nome,
		String matricula,
		String curso,
		String periodo,
		int idade,
		String email,
		String CPF,
		Boolean ativo
		) {
	
	public DadosDetalhamentoAluno(Aluno aluno) {
		this(
				aluno.getId(),
				aluno.getNome(),
				aluno.getMatricula(),
				aluno.getCurso(),
				aluno.getPeriodo(),
				aluno.getIdade(),
				aluno.getEmail(),
				aluno.getCPF(),
				aluno.getAtivo());
	}

}
