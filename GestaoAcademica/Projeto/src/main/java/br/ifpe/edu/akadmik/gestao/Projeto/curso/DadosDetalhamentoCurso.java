package br.ifpe.edu.akadmik.gestao.Projeto.curso;

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
