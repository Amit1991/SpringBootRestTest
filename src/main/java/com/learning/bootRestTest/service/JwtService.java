package com.learning.bootRestTest.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "423F4528482B4D6251655468576D5A7134743777217A25432A46294A404E6352";

    public String extractUsername(String jwtToken) {

        return extractClaim(jwtToken, Claims::getSubject);
    }

    public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {

        final Claims claims = extractAllClaims(jwtToken);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String jwtToken) {

        return Jwts.parserBuilder().setSigningKey(getSingingKey())
                .build().parseClaimsJws(jwtToken).getBody();
    }

    private Key getSingingKey() {

        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateJwtToken(Map<String, Object> extraClaims, UserDetails userDetails)  {

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 5)))
                .signWith(getSingingKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateJwtToken(UserDetails userDetails) {

        return generateJwtToken(new HashMap<>(), userDetails);
    }

    public boolean isTokenValid(String jwtToken, UserDetails userDetails) {

        final String username = extractUsername(jwtToken);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
    }

    private boolean isTokenExpired(String jwtToken) {

        return extractExpiration(jwtToken).before(new Date());
    }

    private Date extractExpiration(String jwtToken) {

        return extractClaim(jwtToken, Claims::getExpiration);
    }
}
