package com.petshop.ambrozziospetshop.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.petshop.ambrozziospetshop.entities.User;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        //List<User> list = service.findAll();
        User u = new User(1L, "rod", "rod@Gmail.com", "999999999", "123456", 1);
        return ResponseEntity.ok().body(u);
    }
}
