package com.example.validation.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @Min(18)
    @Max(60)
    private int age;
    @Email(message = "Email ID is not valid!")
    private String emailId;
    private String mobileNumber;
    @NotNull(message = "Nationality cannot be blank!")
    private String nationality;

}
