package com.nextgen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextgen.dto.LoginResponse;
import com.nextgen.model.UserLogin;
import com.nextgen.util.JwtTokenUtil;

@RestController
@RequestMapping("/app/v1")
public class AuthController {

    @Autowired
    public JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody UserLogin request) {

        // Dummy validation
        if ("admin".equals(request.getUsername())
                && "nitesh".equals(request.getPassword())) {

            String token = jwtTokenUtil.generateToken(request.getUsername());

            return new LoginResponse(token);
        }

        throw new RuntimeException("Invalid username or password");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Secured API";
    }

}
