package com.petshop.ambrozziospetshop.domain.services;

import com.petshop.ambrozziospetshop.domain.dtos.EmployeeDTO;
import com.petshop.ambrozziospetshop.domain.entities.EmployeeEntity;
import com.petshop.ambrozziospetshop.domain.utils.observer.IListener;

import java.util.List;

public interface IEmployeeService extends IListener {
    EmployeeEntity create(EmployeeDTO employeeDTO);

    void update(EmployeeEntity employeeEntity);

    List<EmployeeEntity> findAll();
}
