package com.ifpe.gestaoalunos.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TraradorDeErros {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> tratador404 () {
		return ResponseEntity.notFound().build();
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> tratador400 (MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors();
		
		return ResponseEntity.badRequest().body(erros.stream().map(DadosErros::new).toList());
	}
	
	public record DadosErros(String campo, String mensagem) {
		
		public DadosErros(FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
		
	}

}
