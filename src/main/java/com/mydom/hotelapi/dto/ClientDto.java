package com.mydom.hotelapi.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ClientDto {

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name must be less than 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must be less than 50 characters")
    private String lastName;

    @NotBlank(message = "Phone number is required")
    @Size(max = 20, message = "Phone number must be less than 15 characters")
    private String phoneNumber;

    @Size(max = 100, message = "Email must be less than 100 characters")
    private String email;

    @NotBlank(message = "Passport number is required")
    @Size(max = 20, message = "Passport number must be less than 20 characters")
    private String passportNumber;

    @NotBlank(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    private LocalDateTime createdAt;
}
