package com.sha.springbootbookseller.service;

import com.sha.springbootbookseller.model.User;
import com.sha.springbootbookseller.security.UserPrincipal;
import com.sha.springbootbookseller.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService{
    @Autowired
    private AuthenticationManager authenticationManager;

    private IJwtProvider jwtProvider;

    @Override
    public User singInAndReturnJWT(User singInRequest)
    {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(singInRequest.getUsername(),singInRequest.getPassword())
        );
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        User singInUser = userPrincipal.getUser();
        singInUser.setToken(jwt);
        return singInUser;
    }

}
