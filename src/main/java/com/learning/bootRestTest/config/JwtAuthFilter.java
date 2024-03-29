package com.learning.bootRestTest.config;

import com.learning.bootRestTest.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {


        final String authHeader = request.getHeader("Authorization");
        final String jwtToken;
        final String username;

        if(authHeader == null || !authHeader.startsWith("Bearer "))
        {
            filterChain.doFilter(request, response);
            return;
        }

        jwtToken = authHeader.substring(7);
        username = jwtService.extractUsername(jwtToken);

        if(username != null && !username.isEmpty()
            && SecurityContextHolder.getContext().getAuthentication() != null) {

            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if(jwtService.isTokenValid(jwtToken, userDetails));
        }
    }
}
