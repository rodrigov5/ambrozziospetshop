package com.petshop.ambrozziospetshop.domain.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderDTO {
    @NotNull
    private Long clientId;

    @NotNull
    private Long employeeId;

    @NotNull
    private List<ItemOrderDTO> itemOrderDTOS;
}
