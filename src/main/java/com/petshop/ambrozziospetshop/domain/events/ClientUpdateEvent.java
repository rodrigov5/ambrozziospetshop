package com.petshop.ambrozziospetshop.domain.events;

import com.petshop.ambrozziospetshop.domain.entities.ClientEntity;
import com.petshop.ambrozziospetshop.domain.utils.observer.IEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class ClientUpdateEvent implements IEvent {
    private final ClientEntity clientEntity;
}
