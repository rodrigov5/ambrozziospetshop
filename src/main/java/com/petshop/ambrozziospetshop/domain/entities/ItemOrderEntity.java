package com.petshop.ambrozziospetshop.domain.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "tb_itemorder")
@Getter @Setter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_product_id")
    private ProductEntity productEntity;

    @Column
    private int quantity;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public double getTotPrice() {
        return quantity * productEntity.getPrice();
    }
}
