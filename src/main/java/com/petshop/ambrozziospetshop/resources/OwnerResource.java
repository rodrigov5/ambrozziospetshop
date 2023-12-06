package com.petshop.ambrozziospetshop.resources;

import com.petshop.ambrozziospetshop.entities.Owner;
import com.petshop.ambrozziospetshop.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/owners")
public class OwnerResource {

    @Autowired
    private OwnerService service;

    @GetMapping
    public ResponseEntity<List<Owner>> findAll() {
        List<Owner> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Owner> findById(@PathVariable Long id) {
        Owner obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
