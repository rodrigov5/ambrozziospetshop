package com.petshop.ambrozziospetshop.domain.repositories;

import com.petshop.ambrozziospetshop.domain.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {
}
