package com.petshop.ambrozziospetshop.config;

import com.petshop.ambrozziospetshop.entities.User;
import com.petshop.ambrozziospetshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public void run(String... args) throws Exception {
        User u1 = new User (null, "Rod", "rod@gmail", "999999", "123456", 1);
        User u2 = new User (null, "jao", "jao@gmail", "999999", "123456", 2);

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
