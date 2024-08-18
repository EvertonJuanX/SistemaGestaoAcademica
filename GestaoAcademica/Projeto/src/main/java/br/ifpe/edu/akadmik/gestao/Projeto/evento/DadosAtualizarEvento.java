package br.ifpe.edu.akadmik.gestao.Projeto.evento;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarEvento(
		@NotNull
		Long id,
		String nome, 
		String descricao, 
		String data, 
		String local
		) {

}
