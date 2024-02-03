package com.liefersoft.test.service.impl;

import com.liefersoft.test.dto.RegisterRequest;
import com.liefersoft.test.dto.RegisterResponse;
import com.liefersoft.test.exception.PermissionException;
import com.liefersoft.test.model.Sex;
import com.liefersoft.test.model.User;
import com.liefersoft.test.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser_Success() {
        RegisterRequest registerRequest = new RegisterRequest("Vadym", "Liashok", "0981856273", Sex.MALE, true);
        when(userRepository.save(any(User.class))).thenReturn(new User());

        RegisterResponse response = underTest.registerUser(registerRequest);

        assertNotNull(response);
        assertEquals("You have been registered successfully", response.message());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testRegisterUser_PermissionException() {
        RegisterRequest registerRequest = new RegisterRequest("Vadym", "Liashok", "0981856273", Sex.MALE, false);

        PermissionException exception = assertThrows(PermissionException.class,
                () -> underTest.registerUser(registerRequest));

        assertEquals("User should give permission for the processing of personal data to be registered", exception.getMessage());
        verify(userRepository, never()).save(any(User.class));
    }
}
