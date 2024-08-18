package br.ifpe.edu.akadmik.gestao.Projeto.administrador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {

	UserDetails findByLogin(String login);

}
