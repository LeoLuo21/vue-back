package com.pale.view.controller;
import com.pale.view.jwtutils.TokenManager;
import com.pale.view.vo.JwtRequestModel;
import com.pale.view.vo.JwtResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.GrantedAuthority;

@RestController
public class JwtController {
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final TokenManager tokenManager;

    public JwtController(UserDetailsService userDetailsService, AuthenticationManager authenticationManager, TokenManager tokenManager) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.tokenManager = tokenManager;
    }

    @PostMapping("/login/student")
    public ResponseEntity<Object> createTokenForStudent(@RequestBody JwtRequestModel request) throws Exception {

        System.out.println(request.getUsername());
        System.out.println(request.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword())
            );
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        boolean success = false;
        for (GrantedAuthority auth : userDetails.getAuthorities()) {
            if ("student".equals(auth.getAuthority())) {
                success = true;
                break;
            }
        }
        if (!success) {
            throw new Exception("INVALID_ACCOUNT");
        }
        final String jwtToken = tokenManager.generateJwtToken(userDetails);
        return ResponseEntity.ok(new JwtResponseModel(jwtToken));
    }

    @PostMapping("/login/teacher")
    public ResponseEntity<Object> createTokenForTeacher(@RequestBody JwtRequestModel request) throws Exception {

        System.out.println(request.getUsername());
        System.out.println(request.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword())
            );
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        boolean success = false;
        for (GrantedAuthority auth : userDetails.getAuthorities()) {
            if ("teacher".equals(auth.getAuthority())) {
                success = true;
                break;
            }
        }
        if (!success) {
            throw new Exception("INVALID_ACCOUNT");
        }
        final String jwtToken = tokenManager.generateJwtToken(userDetails);
        return ResponseEntity.ok(new JwtResponseModel(jwtToken));
    }
    @PostMapping("/login/admin")
    public ResponseEntity<Object> createTokenForAdmin(@RequestBody JwtRequestModel request) throws Exception {

        System.out.println(request.getUsername());
        System.out.println(request.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword())
            );
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        boolean success = false;
        for (GrantedAuthority auth : userDetails.getAuthorities()) {
            if ("admin".equals(auth.getAuthority())) {
                success = true;
                break;
            }
        }
        if (!success) {
            throw new Exception("INVALID_ACCOUNT");
        }
        final String jwtToken = tokenManager.generateJwtToken(userDetails);
        return ResponseEntity.ok(new JwtResponseModel(jwtToken));
    }
}
