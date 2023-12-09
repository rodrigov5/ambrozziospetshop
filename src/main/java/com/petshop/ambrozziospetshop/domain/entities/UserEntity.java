package com.petshop.ambrozziospetshop.domain.entities;

import com.petshop.ambrozziospetshop.domain.entities.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "tb_user")
@Getter @Setter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include

    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String password;

    @Column
    private RoleEnum role;
}