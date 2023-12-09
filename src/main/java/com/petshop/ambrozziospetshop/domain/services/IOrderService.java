package com.petshop.ambrozziospetshop.domain.services;

import com.petshop.ambrozziospetshop.domain.dtos.OrderDTO;
import com.petshop.ambrozziospetshop.domain.entities.OrderEntity;

import java.util.List;

public interface IOrderService {
    OrderEntity create(OrderDTO orderDTO);

    List<OrderEntity> findAll();
}
