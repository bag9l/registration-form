package com.liefersoft.test.service.impl;

import com.liefersoft.test.dto.RegisterRequest;
import com.liefersoft.test.dto.RegisterResponse;
import com.liefersoft.test.exception.PermissionException;
import com.liefersoft.test.model.User;
import com.liefersoft.test.repository.UserRepository;
import com.liefersoft.test.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {

        if(!registerRequest.agreeTermsOfUse()){
            throw new PermissionException("User should give permission for the processing of personal data to be registered");
        }

        User user = new User(
                registerRequest.firstName(),
                registerRequest.lastName(),
                registerRequest.phoneNumber(),
                registerRequest.sex()
        );

        userRepository.save(user);

        return new RegisterResponse("You have been registered successfully");
    }
}
