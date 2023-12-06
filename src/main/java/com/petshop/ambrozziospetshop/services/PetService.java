package com.petshop.ambrozziospetshop.services;

import com.petshop.ambrozziospetshop.entities.Pet;
import com.petshop.ambrozziospetshop.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List<Pet> findAll() {
        return repository.findAll();
    }

    public Pet findById(Long id) {
        Optional<Pet> obj = repository.findById(id);
        return obj.get();
    }
}
