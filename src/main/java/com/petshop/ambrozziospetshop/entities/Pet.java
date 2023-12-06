package com.petshop.ambrozziospetshop.entities;

import java.io.Serializable;
import java.util.Objects;

public class Pet implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String species;

    public Pet() {}

    public Pet(Long id, String name, String species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
