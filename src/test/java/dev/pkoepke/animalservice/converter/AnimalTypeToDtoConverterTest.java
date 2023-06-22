package dev.pkoepke.animalservice.converter;

import dev.pkoepke.animalservice.domain.entity.AnimalType;
import dev.pkoepke.animalservice.dto.AnimalTypeDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTypeToDtoConverterTest {
    @Test
    void converts() {
        AnimalTypeToDtoConverter converter = new AnimalTypeToDtoConverter();
        long animalTypeId = 10L;
        String animalTypeName = "LION";
        AnimalType animalType = new AnimalType(animalTypeName);
        animalType.setId(animalTypeId);

        AnimalTypeDto result = converter.convert(animalType);

        assertEquals(animalTypeId, result.getId());
        assertEquals(animalTypeName, result.getName());
    }
}