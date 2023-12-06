package com.petshop.ambrozziospetshop.repositories;

import com.petshop.ambrozziospetshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
