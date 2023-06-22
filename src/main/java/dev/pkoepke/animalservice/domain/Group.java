package dev.pkoepke.animalservice.domain;

import dev.pkoepke.animalservice.domain.entity.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents a Group of one animalType.
 */
@AllArgsConstructor
@Getter
public class Group {

    private AnimalType animalType;

    private int count;

}
