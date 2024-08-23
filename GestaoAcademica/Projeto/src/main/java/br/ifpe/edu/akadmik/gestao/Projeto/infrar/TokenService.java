package br.ifpe.edu.akadmik.gestao.Projeto.infrar;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import br.ifpe.edu.akadmik.gestao.Projeto.administrador.Administrador;

@Service
public class TokenService {

	public String gerarToken(Administrador administrador) {

		try {
			var algorithm = Algorithm.HMAC256("123456");

			return JWT.create().withIssuer("gestao_academica_api").withSubject(administrador.getLogin())
					.withExpiresAt(dataExpiracao())
					.sign(algorithm);

		} catch (JWTCreationException exception) {
			throw new RuntimeException("Error ao gerar token", exception);
		}
	}

	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}