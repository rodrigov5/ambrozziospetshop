package com.petshop.ambrozziospetshop.domain.repositories;

import com.petshop.ambrozziospetshop.domain.entities.ClientEntity;
import com.petshop.ambrozziospetshop.domain.entities.EmployeeEntity;
import com.petshop.ambrozziospetshop.domain.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderEntity, Long> {
    int countAllByClientEntity(ClientEntity clientEntity);

    int countAllByEmployeeEntity(EmployeeEntity employeeEntity);
}
