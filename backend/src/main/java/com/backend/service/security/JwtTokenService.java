package com.backend.service.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

// TODO: 30.3.2022 REMOVE THIS FILE AFTER DONE

@Service
public class JwtTokenService {

    @Value("${SECRET_JWT}")
    private String secret;

    public String generateToken(String projectName, String username, Long id) {
        return Jwts.builder()
                .setIssuer(projectName)
                .setSubject(username)
                .claim("id", id)
                // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
                .setIssuedAt(new Date())
                // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 100000))
                .signWith(
                        Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret)),
                        SignatureAlgorithm.HS256
                )
                .compact();
    }

    public Jws<Claims> parseJwt(String jwtString) throws JwtException {

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());

        return Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(jwtString);
    }

}
