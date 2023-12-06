package com.petshop.ambrozziospetshop.resources;

import com.petshop.ambrozziospetshop.entities.Pet;
import com.petshop.ambrozziospetshop.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pets")
public class PetResource {

    @Autowired
    private PetService service;

    @GetMapping
    public ResponseEntity<List<Pet>> findAll() {
        List<Pet> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pet> findById(@PathVariable Long id) {
        Pet obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
