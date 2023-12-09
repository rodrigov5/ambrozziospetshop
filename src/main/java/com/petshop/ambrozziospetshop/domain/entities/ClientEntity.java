package com.petshop.ambrozziospetshop.domain.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_client")
@Getter @Setter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column
    private double saldo;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

    @OneToMany(mappedBy = "clientEntity")
    private List<PetEntity> petEntities;
}
