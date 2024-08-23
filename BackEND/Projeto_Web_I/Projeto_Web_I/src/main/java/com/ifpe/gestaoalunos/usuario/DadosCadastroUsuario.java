package com.ifpe.gestaoalunos.usuario;

import com.ifpe.gestaoalunos.endereco.Estados;

public record DadosCadastroUsuario(

		String nome, 
		String cpf,
		String rg,
		String dataNascimento,
		String telefone,
		String email,

		Estados estado, 
		String cidade, 
		String cep, 
		String bairro, 
		String rua, 
		String numero, 
		String complemento,

		String nomeBanco, 
		String numConta,
		String agencia,
		String operacao

) {

}
