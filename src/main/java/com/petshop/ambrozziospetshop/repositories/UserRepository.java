package com.petshop.ambrozziospetshop.repositories;

import com.petshop.ambrozziospetshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
