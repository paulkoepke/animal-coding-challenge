package dev.pkoepke.animalservice.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a type of Animal for example LION.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class AnimalType {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public AnimalType(String name) {
        this.name = name;
    }

}
