package com.ifpe.gestaoalunos.banco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository extends JpaRepository<Banco, Long>{
	
	
	List<Banco> findAllByAtivoTrue();

}
