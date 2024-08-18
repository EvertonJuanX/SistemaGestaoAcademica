package br.ifpe.edu.akadmik.gestao.Projeto.usuario;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(

		@NotNull Long id, String nome, String email, String telefone, String cpf, String rg, LocalDate dataNascimento,
		Sexo sexo

) {
}
