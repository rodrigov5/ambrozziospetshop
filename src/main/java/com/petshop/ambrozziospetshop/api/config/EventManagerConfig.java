package com.petshop.ambrozziospetshop.api.config;

import com.petshop.ambrozziospetshop.domain.services.IClientService;
import com.petshop.ambrozziospetshop.domain.services.IEmployeeService;
import com.petshop.ambrozziospetshop.domain.utils.observer.EventManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventManagerConfig {
    private final IClientService clientService;
    private final IEmployeeService employeeService;

    public EventManagerConfig(IClientService clientService, IEmployeeService employeeService) {
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    @Bean
    public EventManager configure() {
        EventManager eventManager = new EventManager();

        eventManager.addListener(clientService);
        eventManager.addListener(employeeService);

        return eventManager;
    }
}
