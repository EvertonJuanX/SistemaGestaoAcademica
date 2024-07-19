package com.ifpe.gestaoalunos.aluno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	List<Aluno> findAllByAtivoTrue();

}
