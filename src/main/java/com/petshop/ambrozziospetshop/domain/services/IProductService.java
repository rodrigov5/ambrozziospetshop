package com.petshop.ambrozziospetshop.domain.services;

import com.petshop.ambrozziospetshop.domain.dtos.ProductDTO;
import com.petshop.ambrozziospetshop.domain.entities.ProductEntity;

import java.util.List;

public interface IProductService {
    ProductEntity create(ProductDTO productDTO);

    List<ProductEntity> findAll();
}
