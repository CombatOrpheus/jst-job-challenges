package com.justa.challenge.controllers;

import com.justa.challenge.models.User;
import com.justa.challenge.payload.request.DeleteRequest;
import com.justa.challenge.payload.request.LoginRequest;
import com.justa.challenge.payload.request.SignUpRequest;
import com.justa.challenge.payload.response.ApiResponse;
import com.justa.challenge.payload.response.MessageResponse;
import com.justa.challenge.repository.UserRepository;
import com.justa.challenge.security.services.UserDetailsImpl;
import com.justa.challenge.security.services.miscellaneous.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    Utils utils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = utils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new ApiResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest SignUpRequest) {
        if (userRepository.existsByUsername(SignUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(SignUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(SignUpRequest.getUsername(),
                SignUpRequest.getEmail(),
                encoder.encode(SignUpRequest.getPassword()));

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteUser(@Valid @RequestBody DeleteRequest deleteRequest) {

        if (!userRepository.existsById(deleteRequest.getId())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: ID does not exist!"));
        }

        if (!userRepository.existsByUsername(deleteRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username does not exist!"));
        }

        if (!userRepository.existsByEmail(deleteRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email does not exist!"));
        }

        return ResponseEntity.ok(new MessageResponse("User deleted successfully!"));
    }
}
