package com.example.venus_teah_poketeam_casestudy.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private static final String SECRET_KEY = "2948404D635166546A576E5A7234753777217A25432A462D4A614E645267556B";

    private Claims extractAllClaims(String jwtObj) {

        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(jwtObj)
                .getBody();
    }
}
