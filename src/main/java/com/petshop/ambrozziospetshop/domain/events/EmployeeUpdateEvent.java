package com.petshop.ambrozziospetshop.domain.events;

import com.petshop.ambrozziospetshop.domain.entities.EmployeeEntity;
import com.petshop.ambrozziospetshop.domain.utils.observer.IEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class EmployeeUpdateEvent implements IEvent {
    private final EmployeeEntity employeeEntity;
}
