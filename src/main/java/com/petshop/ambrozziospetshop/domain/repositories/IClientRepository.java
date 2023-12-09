package com.petshop.ambrozziospetshop.domain.repositories;

import com.petshop.ambrozziospetshop.domain.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity, Long> {
}
