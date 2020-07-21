package com.grootan.quiz.auth;

import com.grootan.quiz.exception.AuthenticationException;
import com.grootan.quiz.service.AuthService;
import com.grootan.quiz.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JwtFilter extends BasicAuthenticationFilter {

    JwtTokenUtil jwtTokenUtil;

    public JwtFilter(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        super(authenticationManager);
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(req);
        System.out.println("1");
        if (authenticationToken == null) {
            chain.doFilter(req, res);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) {
        try {
            Claims claims = getJwtToken(req);
            System.out.println(claims.getSubject());
            return new UsernamePasswordAuthenticationToken(
                    claims.getSubject(),
                    null,
                    Collections.emptyList());
        } catch (AuthenticationException e) {
            return null;
        }
    }

    private Claims getJwtToken(HttpServletRequest httpRequest) throws AuthenticationException {
        String token = httpRequest.getHeader("Authorization");
        if (token == null || token.length() <= 0) {
            throw new AuthenticationException("Token missing");
        }
        String jwt = token.replace("Bearer ", "");
        return jwtTokenUtil.parseJwt(jwt);
    }

    @Override
    public void destroy() {
    }
}