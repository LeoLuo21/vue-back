package com.pale.view.jwtutils;

import com.pale.view.model.User;
import com.pale.view.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class TokenManager implements Serializable {
    private static final long serialVersionUID = 7008375124389347049L;
    public static final long TOKEN_VALIDITY = 10 * 60 * 60;
    @Value("${secret}")
    private String jwtSecret;

    @Autowired
    private UserRepository userRepository;
    public String generateJwtToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        String account = userDetails.getUsername();
        Long id = Long.valueOf(account);
        Optional<User> user = userRepository.findById(id);
        String username = user.get().getUsername();
        return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
                .claim("username",username)
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }
   public Boolean validateJwtToken(String token, UserDetails userDetails) { 
      String username = getUsernameFromToken(token); 
      Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
      Boolean isTokenExpired = claims.getExpiration().before(new Date()); 
      return (username.equals(userDetails.getUsername()) && !isTokenExpired); 
   } 
   public String getUsernameFromToken(String token) {
      final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody(); 
      return claims.getSubject(); 
   } 
}
