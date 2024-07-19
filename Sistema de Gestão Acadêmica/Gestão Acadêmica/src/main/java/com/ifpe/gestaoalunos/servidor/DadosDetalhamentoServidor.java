package com.ifpe.gestaoalunos.servidor;

public record DadosDetalhamentoServidor(
		
		Long id,
		String nome,
		String siape,
		String CPF,
		String RG,
		int idade,
		String email,
		String cargo,
		Boolean ativo
		) {
	
	public DadosDetalhamentoServidor(Servidor servidor) {
		this(
				servidor.getId(),
				servidor.getNome(),
				servidor.getSiape(),
				servidor.getCPF(),
				servidor.getRG(),
				servidor.getIdade(),
				servidor.getEmail(),
				servidor.getCargo(),
				servidor.getAtivo());
		
	}

}
