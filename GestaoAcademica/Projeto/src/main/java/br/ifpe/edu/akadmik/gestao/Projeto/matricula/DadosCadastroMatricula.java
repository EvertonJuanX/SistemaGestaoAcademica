package br.ifpe.edu.akadmik.gestao.Projeto.matricula;

public record DadosCadastroMatricula(Long id, String numMatricula, String periodoIngresso, String turno,
		
		  Long idAluno,
		    Long idCurso) {

}
