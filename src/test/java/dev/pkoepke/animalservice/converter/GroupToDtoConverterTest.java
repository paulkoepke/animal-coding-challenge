package dev.pkoepke.animalservice.converter;

import dev.pkoepke.animalservice.domain.Group;
import dev.pkoepke.animalservice.domain.entity.AnimalType;
import dev.pkoepke.animalservice.dto.AnimalTypeDto;
import dev.pkoepke.animalservice.dto.GroupDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GroupToDtoConverterTest {
    @Mock
    private AnimalTypeToDtoConverter animalTypeToDtoConverter;

    @InjectMocks
    private GroupToDtoConverter converter;


    @Test
    void converts() {
        String animalTypeName = "LION";
        int animalTypeCount = 10;
        AnimalType animalType = new AnimalType(animalTypeName);
        Group group = new Group(animalType, animalTypeCount);
        AnimalTypeDto animalTypeDto = new AnimalTypeDto();
        animalTypeDto.setName(animalTypeName);
        when(animalTypeToDtoConverter.convert(animalType)).thenReturn(animalTypeDto);

        GroupDto result = converter.convert(group);

        assertEquals(animalTypeDto, result.getAnimalType());
        assertEquals(animalTypeCount, result.getCount());
    }
}