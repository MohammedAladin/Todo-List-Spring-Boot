package com.SpringBoot.Course.springnoot.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class TokenUtil {

    private final String CLAIMS_SUBJECT="sub";
    private final String CLAIMS_CREATED="created";

    @Value("${auth.expiration}")
    private final long TOKEN_VALIDITY = 604800L;

    @Value("${auth.secret}")
    private String TOKEN_SECRET;

    public String generateToken(UserDetails userDetails){

        Map<String, Object> Claims = new HashMap<>();
        Claims.put(CLAIMS_SUBJECT, userDetails.getUsername());
        Claims.put(CLAIMS_CREATED, new Date());

        return Jwts.builder()
                .setClaims(Claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET)
                .compact();

    }
    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000);
    }
}
