package br.ifpe.edu.akadmik.gestao.Projeto.usuario;

import java.time.LocalDate;

public record DadosDetalhamentoUsuario(

		Long id, 
		String nome, 
		String cpf, 
		String rg, 
		LocalDate dataNascimento, 
		String telefone, 
		String email, 
		Sexo sexo,
		Boolean ativo

) {
	public DadosDetalhamentoUsuario(Usuario usuario) {
		this(usuario.getId(), usuario.getNome(), usuario.getCpf(), usuario.getRg(), usuario.getDataNascimento(),
				usuario.getTelefone(), usuario.getEmail(), usuario.getSexo(), usuario.getAtivo());

	}

}
