package com.ifpe.gestaoalunos.servidor;

import java.util.List;

import com.ifpe.gestaoalunos.evento.Evento;
import com.ifpe.gestaoalunos.usuario.Usuario;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
	
	private String siepe; 

	private String cargo;
	@ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")  // Chave estrangeira para a tabela Usuario
    private Usuario usuario;

	@OneToMany(mappedBy = "servidor")
	private List<Evento> evento;
	
	public Servidor(DadosCadastroServidor dados) {
		super(dados);
        this.siepe = dados.siepe();
        this.cargo = dados.cargo();
    }

    public void atualizarInformacoes(DadosAtualizarServidor dados) {
        if (dados.siepe() != null) {
            this.siepe = dados.siepe();
        }
        if (dados.cargo() != null) {
            this.cargo = dados.cargo();
        }
    }
/*
    public void inativar() {
        super.inativar(); 
    }

    public void reativar() {
        super.reativar(); // Chama o método reativar da classe pai Usuario
    }*/
}
