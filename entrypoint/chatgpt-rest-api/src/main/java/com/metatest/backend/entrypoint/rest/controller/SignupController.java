package com.metatest.backend.entrypoint.rest.controller;

import com.metatest.backend.entrypoint.rest.adapter.AuthenticationAdapter;
import com.metatest.backend.entrypoint.rest.mapper.SignupRequest2SignupMapper;
import com.metatest.backend.entrypoint.rest.model.input.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SignupController {

    private final AuthenticationAdapter authenticationAdapter;
    private final SignupRequest2SignupMapper signupRequest2SignupMapper;


    @GetMapping("/sign-up")
    public String showSignUpPage(Model model) {
        return "signup";
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
        var signup = signupRequest2SignupMapper.map(signupRequest);
        var createdUser = authenticationAdapter.signupUser(signup);
        if (createdUser == null){
            return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
