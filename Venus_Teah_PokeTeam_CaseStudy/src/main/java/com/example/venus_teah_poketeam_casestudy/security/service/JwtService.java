//package com.example.venus_teah_poketeam_casestudy.security.service;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Service;
//
//import java.security.Key;
//import java.util.Base64;
//import java.util.function.Function;
//
//@Service
//public class JwtService {
//    private static final String SECRET_KEY = "2948404D635166546A576E5A7234753777217A25432A462D4A614E645267556B";
//
//    //SIGNATURE
//    private Key getSignInKey() {
////        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
//        byte[] decodedKey = Base64.getDecoder().decode(SECRET_KEY);
//        return Keys.hmacShaKeyFor(decodedKey);
//    }
//
//    //EXTRACT CLAIMS OF TOKEN
//    private Claims extractAllClaims(String jwt) {
//
//        return Jwts
//                .parserBuilder()
//                .setSigningKey(getSignInKey())
//                .build()
//                .parseClaimsJws(jwtObj)
//                .getBody();
//    }
//
//    public <T> T extractClaim(String jwt, Function<Claims, T> Resolver) {
//        final Claims claims = extractAllClaims(jwt);
//        return Resolver.apply(claims);
//    }
//
//
//    //
//
//
//
//
//
//
//    //Subject Token = Username/Email
//    public String extractSubjectToken(String jwtObj) {
//        return
//    }
//
//
//
//}
