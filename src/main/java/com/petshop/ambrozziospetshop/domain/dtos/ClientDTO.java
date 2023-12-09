package com.petshop.ambrozziospetshop.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClientDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotNull
    private double saldo;

    @NotBlank
    private String phone;

    @NotBlank
    private String password;
}
