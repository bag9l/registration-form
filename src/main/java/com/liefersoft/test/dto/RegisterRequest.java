package com.liefersoft.test.dto;

import com.liefersoft.test.model.Sex;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "first name must not be empty")
        @Size(min = 2, max = 30, message = "first name length must be minimum 2 and maximum 30 characters")
        String firstName,
        @NotBlank(message = "last name must not be empty")
        @Size(min = 2, max = 30, message = "last name length must be minimum 2 and maximum 30 characters")
        String lastName,

        @Pattern(regexp = "\\d+", message = "phone number must contain only a numbers")
        @Size(min = 7, max = 10, message = "phone number length must be minimum 7 and maximum 10 characters")
        String phoneNumber,

        @NotNull
        Sex sex,
        @NotNull
        Boolean agreeTermsOfUse
) {
}
