package com.ifpe.gestaoalunos.usuario;

import java.time.LocalDate;

public record DadosDetalhamentoUsuario(

		Long id, 
		String nome, 
		String cpf, 
		String rg, 
		String dataNascimento, 
		String telefone, 
		String email

) {
	public DadosDetalhamentoUsuario(Usuario usuario) {
		this(usuario.getId(), usuario.getNome(), usuario.getCpf(), usuario.getRg(), usuario.getDataNascimento(),
				usuario.getTelefone(), usuario.getEmail());

	}

}
