package com.petshop.ambrozziospetshop.resources;

import com.petshop.ambrozziospetshop.entities.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pets")
public class PetResource {

    @GetMapping
    public ResponseEntity<Pet> findAll() {
        //List<User> list = service.findAll();
        Pet u = new Pet(1L, "Bob", "Dog");
        return ResponseEntity.ok().body(u);
    }
}
