package com.petshop.ambrozziospetshop.domain.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_pet")
@Getter @Setter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column
    private String name;

    @ManyToOne
    private BreedEntity breedEntity;

    @Column
    private Timestamp birthDate;

    @ManyToOne
    @JoinColumn(name = "fk_client_id")
    private ClientEntity clientEntity;
}
