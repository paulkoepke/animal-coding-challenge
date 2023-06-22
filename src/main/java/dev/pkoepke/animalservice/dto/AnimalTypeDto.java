package dev.pkoepke.animalservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO for a AnimalType. Contains validations to be used as input DTO.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnimalTypeDto {

    private Long id;

    @NotBlank
    @Size(min = 1, max = 20)
    private String name;
}
