package br.ifpe.edu.akadmik.gestao.Projeto.matricula;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula,Long>{
	
	List<Matricula> findAllByAtivoTrue();
}
