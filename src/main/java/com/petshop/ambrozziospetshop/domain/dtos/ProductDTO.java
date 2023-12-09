package com.petshop.ambrozziospetshop.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String imgUrl;

    @NotNull
    private double price;

    @NotNull
    private int quantity;
}
