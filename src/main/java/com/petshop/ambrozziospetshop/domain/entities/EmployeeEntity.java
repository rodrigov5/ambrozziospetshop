package com.petshop.ambrozziospetshop.domain.entities;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "tb_employee")
@Getter @Setter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmployeeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column
    private double salario;

    @Column //BONIFICACAO
    private double bonus;

    @Column
    private String cpf;

    @Column
    private String rg;

    @Column
    private String zipCode;

    @Column
    private Timestamp birthDate;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;
}
