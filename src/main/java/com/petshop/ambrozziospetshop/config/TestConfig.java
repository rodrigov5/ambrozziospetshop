package com.petshop.ambrozziospetshop.config;

import com.petshop.ambrozziospetshop.entities.Owner;
import com.petshop.ambrozziospetshop.entities.Pet;
import com.petshop.ambrozziospetshop.entities.Product;
import com.petshop.ambrozziospetshop.entities.User;
import com.petshop.ambrozziospetshop.repositories.OwnerRepository;
import com.petshop.ambrozziospetshop.repositories.PetRepository;
import com.petshop.ambrozziospetshop.repositories.ProductRepository;
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

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private ProductRepository productRepository;

    public void run(String... args) throws Exception {
        User u1 = new User (null, "Rod", "rod@gmail", "999999", "123456", 1);
        User u2 = new User (null, "jao", "jao@gmail", "999999", "123456", 2);

        Pet p1 = new Pet(null, "cruelo", "cachorro" ,"Dalmata","1234", "oi");
        Pet p2 = new Pet(null, "cruelo", "cachorro" ,"Dalmata","1234", "oi");

        Owner o1 = new Owner(1L, "123,456,789-10", "123456789", "rua 1", "cidade 1", "estado 1", "123456", "pais 1", "01/01/2001", "cruelo");
        Owner o2 = new Owner(1L, "123,456,789-10", "123456789", "rua 1", "cidade 1", "estado 1", "123456", "pais 1", "01/01/2001", "cruelo");

        Product pro1 = new Product(1L, "rod", 23, 3);
        Product pro2 = new Product(1L, "rod", 23, 3);

        userRepository.saveAll(Arrays.asList(u1, u2));
        petRepository.saveAll(Arrays.asList(p1, p2));
        ownerRepository.saveAll(Arrays.asList(o1, o2));
        productRepository.saveAll(Arrays.asList(pro1, pro2));
    }
}
