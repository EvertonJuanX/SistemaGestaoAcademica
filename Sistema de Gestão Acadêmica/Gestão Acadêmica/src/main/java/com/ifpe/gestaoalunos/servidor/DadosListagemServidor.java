package com.ifpe.gestaoalunos.servidor;

public record DadosListagemServidor(Long id,String nome, String siape, String CPF, String RG, String email, String cargo) {
	
	public DadosListagemServidor(Servidor servidor) {
		this(servidor.getId(),servidor.getNome(),servidor.getSiape(),servidor.getCPF(),servidor.getRG(),servidor.getEmail(), servidor.getCargo());
	}

}
