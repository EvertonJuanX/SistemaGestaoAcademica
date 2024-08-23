package com.ifpe.gestaoalunos.servidor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServidorRepository extends JpaRepository<Servidor, Long> {
    //List<Servidor> findAllByAtivoTrue();

}
