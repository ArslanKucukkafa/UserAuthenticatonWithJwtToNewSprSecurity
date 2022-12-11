package com.example.fieldauthapp.config;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtTokenUtil implements Serializable {

private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

public final String secret;
private final long tokenValidty;


    public JwtTokenUtil(@Value("${app.jwt.secret}") String secret,@Value("${app.jwt.token.validity}") long tokenValidty) {
        this.secret = secret;
        this.tokenValidty = tokenValidty;
    }


    public String generateToken(Authentication authentication) {
        final String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));

        String token= Jwts.builder().setSubject(authentication.getName()).setExpiration(new Date(System.currentTimeMillis()+1000*tokenValidty))
                .setIssuer("Arslan").claim("roles",authorities).setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256,secret).compact();

        return token;
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean tokenValidate(String token) {
        Boolean exprationStatus = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration().after(new Date(System.currentTimeMillis()));
        if (exprationStatus && getUsernameFromToken(token) != null) {
            return true;
        }
        return false;
    }








    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

}
