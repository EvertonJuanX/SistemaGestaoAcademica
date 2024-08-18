package br.ifpe.edu.akadmik.gestao.Projeto.endereco;


public record DadosListagemEndereco(
		Long id,
		Boolean ativo, Estados estado, String cidade, String cep, String bairro, String rua, String numero,
		String complemento) {

	public DadosListagemEndereco(Endereco endereco) {
		this(endereco.getId(),endereco.getAtivo(),endereco.getEstado(),
				endereco.getCidade(),endereco.getCep(),endereco.getBairro()
				,endereco.getRua(),endereco.getNumero(),endereco.getComplemento());
	
	}
	

}
