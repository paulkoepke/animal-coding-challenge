package dev.pkoepke.animalservice.facade;

import dev.pkoepke.animalservice.converter.AnimalTypeDtoToEntityConverter;
import dev.pkoepke.animalservice.converter.AnimalTypeToDtoConverter;
import dev.pkoepke.animalservice.domain.entity.AnimalType;
import dev.pkoepke.animalservice.dto.AnimalTypeDto;
import dev.pkoepke.animalservice.service.AnimalTypeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnimalTypeFacadeTest {
    @Mock
    private AnimalTypeService animalTypeService;


    @Mock
    private AnimalTypeDtoToEntityConverter animalTypeDtoToEntityConverter;

    @Mock
    private AnimalTypeToDtoConverter animalTypeToDtoConverter;


    @InjectMocks
    private AnimalTypeFacade animalTypeFacade;

    @Test
    void createAnimalType() {
        AnimalTypeDto animalTypeInputDto = new AnimalTypeDto();
        AnimalTypeDto animalTypeOutputDto = new AnimalTypeDto();
        AnimalType animalTypeInput = new AnimalType();
        AnimalType animalTypeOutput = new AnimalType();
        when(animalTypeDtoToEntityConverter.convert(any())).thenReturn(animalTypeInput);
        when(animalTypeService.create(animalTypeInput)).thenReturn(animalTypeOutput);
        when(animalTypeToDtoConverter.convert(animalTypeOutput)).thenReturn(animalTypeOutputDto);

        AnimalTypeDto result = animalTypeFacade.create(animalTypeInputDto);

        assertEquals(animalTypeOutputDto, result);
    }
}