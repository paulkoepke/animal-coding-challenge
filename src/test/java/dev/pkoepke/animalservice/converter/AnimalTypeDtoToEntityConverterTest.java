package dev.pkoepke.animalservice.converter;

import dev.pkoepke.animalservice.domain.entity.AnimalType;
import dev.pkoepke.animalservice.dto.AnimalTypeDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AnimalTypeDtoToEntityConverterTest {

    @Test
    void converts() {
        AnimalTypeDtoToEntityConverter converter = new AnimalTypeDtoToEntityConverter();
        String animalTypeName = "LION";
        AnimalTypeDto animalTypeDto = new AnimalTypeDto();
        animalTypeDto.setName(animalTypeName);
        AnimalType result = converter.convert(animalTypeDto);
        assertEquals(animalTypeName, result.getName());
        assertNull(result.getId());
    }
}