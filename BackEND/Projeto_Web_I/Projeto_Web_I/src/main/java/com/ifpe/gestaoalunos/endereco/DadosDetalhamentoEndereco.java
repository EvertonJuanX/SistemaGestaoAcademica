package com.ifpe.gestaoalunos.endereco;


public record DadosDetalhamentoEndereco(

		Long id,
		Estados estado,
		String cidade, 
		String cep, 
		String bairro, 
		String rua, 
		String numero, 
		String complemento

) {
	public DadosDetalhamentoEndereco(Endereco endereco) {
        this(
            endereco.getId(),
            endereco.getEstado(), 
            endereco.getCidade(), 
            endereco.getCep(), 
            endereco.getBairro(), 
            endereco.getRua(), 
            endereco.getNumero(), 
            endereco.getComplemento() 
//    		List<Usuario> usuario
//			endereco.getUsuario()
        );
    }
}
