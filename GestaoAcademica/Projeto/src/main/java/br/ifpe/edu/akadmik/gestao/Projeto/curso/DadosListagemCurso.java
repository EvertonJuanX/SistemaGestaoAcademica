package br.ifpe.edu.akadmik.gestao.Projeto.curso;

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
