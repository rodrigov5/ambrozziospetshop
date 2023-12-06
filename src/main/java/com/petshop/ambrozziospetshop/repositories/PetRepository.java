package com.petshop.ambrozziospetshop.repositories;

import com.petshop.ambrozziospetshop.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
