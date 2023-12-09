package com.petshop.ambrozziospetshop.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_breed")
public class BreedEntity {
    @Id
    private String name;
}
