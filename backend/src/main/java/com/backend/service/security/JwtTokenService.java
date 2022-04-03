package com.backend.service.security;


import com.backend.model.MyUserPrincipal;
import com.backend.model.User;
import com.backend.service.security.configuration.AuthenticationService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtTokenService {

    @Value("${SECRET_JWT}")
    private String secret;
    private final AuthenticationService authenticationService;

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();

        User userPrincipal = ((MyUserPrincipal) userDetails).getUser();

        claims.put("userId", userPrincipal.getId());
        claims.put("username", userPrincipal.getUsername());
        claims.put("roles", userPrincipal.getRoles());

        return createToken(claims, userDetails);
    }

    private String createToken(Map<String, Object> claims, UserDetails userDetails) {

        // TODO: 3.4.2022 change the expiration from hardcoded to dynamic?
        Date date = new Date(System.currentTimeMillis());
        Date expiration = new Date(System.currentTimeMillis() + 1200 * 1000);


        // TODO: 3.4.2022 what's wrong with .signWith? I should change this
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setClaims(claims)
                .setIssuedAt(date)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String extractUsername(String token) {
        return (String) extractAllClaims(token).get("username");
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {

        final String username = extractUsername(token);

        if (username.equals(userDetails.getUsername()) && !isTokenExpired(token)) {
            authenticationService.authenticateUser(token);
            return true;
        }
        return false;
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Long extractUserId(String token) {
        return extractAllClaims(token).get("userId", Long.class);
    }

}
