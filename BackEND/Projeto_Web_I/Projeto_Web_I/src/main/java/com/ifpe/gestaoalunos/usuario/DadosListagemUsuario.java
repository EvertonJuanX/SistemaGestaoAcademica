package com.ifpe.gestaoalunos.usuario;

public record DadosListagemUsuario(
		
		Long id, 
		String nome,
		String cpf,
		String rg,
		String dataNascimento,
		String telefone, 
		String email
		
		
		) {

	public DadosListagemUsuario(Usuario usuario) {
		this(usuario.getId(), usuario.getNome(),
				usuario.getCpf(), usuario.getRg(),
				usuario.getDataNascimento(),
				usuario.getTelefone(), usuario.getEmail());
	}

}
