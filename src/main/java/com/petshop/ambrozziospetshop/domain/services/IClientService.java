package com.petshop.ambrozziospetshop.domain.services;

import com.petshop.ambrozziospetshop.domain.dtos.ClientDTO;
import com.petshop.ambrozziospetshop.domain.entities.ClientEntity;
import com.petshop.ambrozziospetshop.domain.utils.observer.IListener;

import java.util.List;

public interface IClientService extends IListener {
    ClientEntity create(ClientDTO clientDTO);

    void update(ClientEntity clientEntity);

    List<ClientEntity> findAll();
}
