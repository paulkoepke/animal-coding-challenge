package dev.pkoepke.animalservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO for a Group.
 */
@Getter
@Setter
public class GroupDto {

    private AnimalTypeDto animalType;

    private int count;

}
