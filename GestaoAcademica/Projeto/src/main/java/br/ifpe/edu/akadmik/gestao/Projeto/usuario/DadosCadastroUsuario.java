package br.ifpe.edu.akadmik.gestao.Projeto.usuario;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(

		@NotBlank String nome,
		@CPF String cpf,
		@NotBlank String rg, 
		
		@JsonFormat(pattern = "yyyy/MM/dd") 
		LocalDate dataNascimento,
		@NotBlank
		String telefone,

		@Email 
		String email,

		@Enumerated 
		Sexo sexo) {

}