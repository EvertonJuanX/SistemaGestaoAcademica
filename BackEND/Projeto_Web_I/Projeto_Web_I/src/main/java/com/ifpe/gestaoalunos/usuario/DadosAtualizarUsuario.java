package com.ifpe.gestaoalunos.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsuario(

		 Long id, String nome, String email, String telefone, String cpf, String rg, String dataNascimento

) {
}
