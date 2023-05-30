package com.SpringBoot.Course.springnoot.Controllers;

import com.SpringBoot.Course.springnoot.security.SignInRequest;
import com.SpringBoot.Course.springnoot.security.TokenResponse;
import com.SpringBoot.Course.springnoot.security.TokenUtil;
import com.SpringBoot.Course.springnoot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping({"/",""})
    public TokenResponse signIn(@RequestBody SignInRequest signInRequest){
        final Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUserName(), signInRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(auth);
        UserDetails userDetails = userService.loadUserByUsername(signInRequest.getUserName());

        String token = tokenUtil.generateToken(userDetails);
        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);
        return tokenResponse;

    }
}
