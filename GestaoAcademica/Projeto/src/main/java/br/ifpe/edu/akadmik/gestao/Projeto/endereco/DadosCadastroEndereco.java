package br.ifpe.edu.akadmik.gestao.Projeto.endereco;

import java.util.List;

import br.ifpe.edu.akadmik.gestao.Projeto.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroEndereco(

		@NotBlank
		Long id,

		Estados estado, 
		
		@NotBlank
		String cidade,
		
		@NotBlank
		String cep, 
		
		@NotBlank
		String bairro, 
		
		@NotBlank
		String rua, 
		
		@NotBlank
		String numero, 
		
		@NotBlank
		String complemento,
		
		List<Usuario> usuario


) {

}
