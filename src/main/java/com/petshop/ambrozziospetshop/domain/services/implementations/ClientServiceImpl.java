package com.petshop.ambrozziospetshop.domain.services.implementations;

import com.petshop.ambrozziospetshop.domain.dtos.ClientDTO;
import com.petshop.ambrozziospetshop.domain.entities.ClientEntity;
import com.petshop.ambrozziospetshop.domain.entities.UserEntity;
import com.petshop.ambrozziospetshop.domain.events.ClientUpdateEvent;
import com.petshop.ambrozziospetshop.domain.repositories.IClientRepository;
import com.petshop.ambrozziospetshop.domain.services.IClientService;
import com.petshop.ambrozziospetshop.domain.utils.observer.IEvent;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {
    private final IClientRepository clientRepository;

    public ClientServiceImpl(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientEntity create(ClientDTO clientDTO) {
        UserEntity userEntity = new UserEntity();
        ClientEntity clientEntity = new ClientEntity();

        BeanUtils.copyProperties(clientDTO, userEntity);
        clientEntity.setUserEntity(userEntity);

        return clientRepository.save(clientEntity);
    }

    @Override
    public void update(ClientEntity clientEntity) {
        clientRepository.save(clientEntity);
    }

    @Override
    public List<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void notify(IEvent event) {
        if (event.getClass() == ClientUpdateEvent.class) {
            ClientUpdateEvent clientUpdateEvent = (ClientUpdateEvent) event;

            update(clientUpdateEvent.getClientEntity());
        }
    }
}
