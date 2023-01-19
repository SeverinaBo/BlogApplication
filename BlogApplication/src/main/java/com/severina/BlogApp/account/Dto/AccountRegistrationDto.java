package com.severina.BlogApp.account.Dto;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class AccountRegistrationDto {

    //need @valid annotation

        @Size(min = 2, max = 60, message="{firstNameError}")
        private String firstName;

        @Size(min = 2, max = 60, message="{lastNameError}")
        private String lastName;

        @NotEmpty
        @Email(message = "{emailError}")
        private String email;

        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{2,8}$", message = "{passwordError}")
        private String password;

}
