package com.mk.springbootapp.utility;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {
	private final String SECRET = "mysecretkeymysecretkeymysecretkey12";
	private final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes());
	private final long EXPIRATION_TIME = 1000 * 60 * 60;

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(KEY, SignatureAlgorithm.HS256).compact();
	}

	public String extractUsername(String token) {
		Claims body = extractClaims(token);
		
		return body.getSubject();
	}

	private Claims extractClaims(String token) {
		return Jwts.parserBuilder()
			.setSigningKey(SECRET.getBytes())
			.build()
			.parseClaimsJws(token)
			.getBody();
	}
	
	public boolean validateToken(String username, UserDetails userDetails, String token) {
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token) ;
	}

	private boolean isTokenExpired(String token) {
		Claims body = extractClaims(token);

		return body.getExpiration().before(new Date());
	}
}
