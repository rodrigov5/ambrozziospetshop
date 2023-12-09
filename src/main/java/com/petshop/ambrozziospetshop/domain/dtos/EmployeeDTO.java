package com.petshop.ambrozziospetshop.domain.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class EmployeeDTO {
    @NotBlank
    private String cpf;

    @NotBlank
    private String rg;

    @NotBlank
    private String zipCode;

    @NotNull
    private Timestamp birthDate;

    @NotNull
    private double salario;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String password;
}
