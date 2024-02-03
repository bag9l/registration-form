package com.liefersoft.test.controller;

import com.liefersoft.test.dto.RegisterRequest;
import com.liefersoft.test.dto.RegisterResponse;
import com.liefersoft.test.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest registerRequest) {
        System.out.println("User:\n\n" + registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                userService.registerUser(registerRequest)
        );
    }
}
