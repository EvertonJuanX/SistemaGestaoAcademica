package com.ifpe.gestaoalunos.endereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	List<Endereco> findAllByAtivoTrue();

}
