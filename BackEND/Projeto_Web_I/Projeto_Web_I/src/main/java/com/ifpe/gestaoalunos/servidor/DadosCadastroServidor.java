package com.ifpe.gestaoalunos.servidor;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ifpe.gestaoalunos.endereco.Estados;
import com.ifpe.gestaoalunos.usuario.Sexo;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroServidor(  
		
		String nome,
		String cpf,
		String rg, 
		
		String dataNascimento,
		
		String telefone,

		
		String email,

		
		String siepe,
	    String cargo,
		
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
