package br.ifpe.edu.akadmik.gestao.Projeto.servidor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServidorRepository extends JpaRepository<Servidor, Long> {
    List<Servidor> findAllByAtivoTrue();

}
