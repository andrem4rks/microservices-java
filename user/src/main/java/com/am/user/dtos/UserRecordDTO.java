package com.am.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRecordDTO(@NotBlank(message = "O nome não deve ser vazio.") String name,
                            @NotBlank(message = "O email não deve ser vazio.") @Email(message = "Email inválido.") String email) {

}
