package com.poogie.sns.user.dao;

import com.poogie.sns.security.JwtDto;
import com.poogie.sns.security.JwtProvider;
import com.poogie.sns.user.dto.AuthRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserDetailsService jwtUserDetailsService;
    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    public JwtDto signIn(AuthRequestDto.SignIn req) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                req.getEmail(),
                req.getPassword()
        );

        Authentication auth = authenticationManager.authenticate(authToken);

        if(auth.isAuthenticated()) {
            UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(req.getEmail());

            return JwtDto.builder()
                    .accessJwt(jwtProvider.create(userDetails))
                    .user(userRepository.findByEmail(req.getEmail()))
                    .build();
        }

        return JwtDto.builder()
                .accessJwt("")
                .build();
    }


}
