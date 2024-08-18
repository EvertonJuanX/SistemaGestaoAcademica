package br.ifpe.edu.akadmik.gestao.Projeto.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findAllByAtivoTrue();
	
		

}
