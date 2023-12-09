package com.petshop.ambrozziospetshop.domain.repositories;

import com.petshop.ambrozziospetshop.domain.entities.ItemOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemOrderRepository extends JpaRepository<ItemOrderEntity, Long> {
}
