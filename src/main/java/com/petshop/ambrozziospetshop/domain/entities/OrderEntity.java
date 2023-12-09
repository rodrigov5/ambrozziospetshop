package com.petshop.ambrozziospetshop.domain.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_order")
@Getter @Setter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_client_id")
    private ClientEntity clientEntity;

    @ManyToOne
    @JoinColumn(name = "fk_employee_id")
    private EmployeeEntity employeeEntity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemOrderEntity> itemOrderEntities = new ArrayList<>();
}
