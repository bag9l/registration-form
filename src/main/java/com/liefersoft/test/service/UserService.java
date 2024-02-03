package com.liefersoft.test.service;

import com.liefersoft.test.dto.RegisterRequest;
import com.liefersoft.test.dto.RegisterResponse;

public interface UserService {
    RegisterResponse registerUser(RegisterRequest registerRequest);
}
