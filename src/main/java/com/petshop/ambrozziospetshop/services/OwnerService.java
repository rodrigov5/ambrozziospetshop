package com.petshop.ambrozziospetshop.services;

import com.petshop.ambrozziospetshop.entities.Owner;
import com.petshop.ambrozziospetshop.repositories.OwnerRepository;
import com.petshop.ambrozziospetshop.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository repository;

    public List<Owner> findAll() {
        return repository.findAll();
    }

    public Owner findById(Long id) {
        Optional<Owner> obj = repository.findById(id);
        return obj.get();
    }
}
