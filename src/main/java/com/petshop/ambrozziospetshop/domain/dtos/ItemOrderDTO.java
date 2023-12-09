package com.petshop.ambrozziospetshop.domain.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemOrderDTO {
    @NotNull
    private Long productId;

    @NotNull @Min(1)
    private int quantity;
}
