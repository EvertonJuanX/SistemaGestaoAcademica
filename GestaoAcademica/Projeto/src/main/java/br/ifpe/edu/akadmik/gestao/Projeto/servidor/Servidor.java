package br.ifpe.edu.akadmik.gestao.Projeto.servidor;

import java.util.List;

import br.ifpe.edu.akadmik.gestao.Projeto.evento.Evento;
import br.ifpe.edu.akadmik.gestao.Projeto.usuario.Usuario;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name= "servidor")
@DiscriminatorValue("Servidor")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Servidor extends Usuario{
	
	private Long id;
	
	private String siepe; 

	private String cargo;
	
	private Long idUsuario;

	@OneToMany(mappedBy = "servidor")
	private List<Evento> evento;
	
	public Servidor(DadosCadastroServidor dados) {
        super(); // Chama o construtor da classe pai Usuario
        this.siepe = dados.siepe();
        this.cargo = dados.cargo();
        this.idUsuario = dados.idUsuario();
    }

    public void atualizarInformacoes(DadosAtualizarServidor dados) {
        if (dados.siepe() != null) {
            this.siepe = dados.siepe();
        }
        if (dados.cargo() != null) {
            this.cargo = dados.cargo();
        }
    }

    public void inativar() {
        super.inativar(); 
    }

    public void reativar() {
        super.reativar(); // Chama o método reativar da classe pai Usuario
    }
}
