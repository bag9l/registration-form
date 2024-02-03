package com.liefersoft.test.controller;

import com.liefersoft.test.dto.RegisterRequest;
import com.liefersoft.test.dto.RegisterResponse;
import com.liefersoft.test.model.Sex;
import com.liefersoft.test.service.UserService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegister_Success() {
        RegisterRequest registerRequest = new RegisterRequest("Vadym", "Liashok", "0981856273", Sex.MALE, true);
        when(userService.registerUser(any(RegisterRequest.class))).thenReturn(new RegisterResponse("Registration successful"));

        ResponseEntity<RegisterResponse> responseEntity = underTest.register(registerRequest);

        assertNotNull(responseEntity);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("Registration successful", responseEntity.getBody().message());
        verify(userService, times(1)).registerUser(any(RegisterRequest.class));
    }
}


