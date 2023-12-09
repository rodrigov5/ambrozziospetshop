package com.petshop.ambrozziospetshop.domain.services.implementations;

import com.petshop.ambrozziospetshop.domain.dtos.EmployeeDTO;
import com.petshop.ambrozziospetshop.domain.entities.EmployeeEntity;
import com.petshop.ambrozziospetshop.domain.entities.enums.RoleEnum;
import com.petshop.ambrozziospetshop.domain.entities.UserEntity;
import com.petshop.ambrozziospetshop.domain.events.EmployeeUpdateEvent;
import com.petshop.ambrozziospetshop.domain.repositories.IEmployeeRepository;
import com.petshop.ambrozziospetshop.domain.services.IEmployeeService;
import com.petshop.ambrozziospetshop.domain.utils.observer.IEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;

    public EmployeeServiceImpl(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeEntity create(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(employeeDTO, userEntity);
        BeanUtils.copyProperties(employeeDTO, employeeEntity);

        userEntity.setRole(RoleEnum.EMPLOYEE);
        employeeEntity.setUserEntity(userEntity);
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void update(EmployeeEntity employeeEntity) {
        employeeRepository.save(employeeEntity);
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void notify(IEvent event) {
        if (event.getClass() == EmployeeUpdateEvent.class) {
            EmployeeUpdateEvent employeeUpdateEvent = (EmployeeUpdateEvent) event;

            update(employeeUpdateEvent.getEmployeeEntity());
        }
    }
}
