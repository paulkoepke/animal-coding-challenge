package dev.pkoepke.animalservice.service;

import dev.pkoepke.animalservice.domain.entity.AnimalType;
import dev.pkoepke.animalservice.repository.AnimalTypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnimalTypeServiceTest {
    @Mock
    private AnimalTypeRepository animalTypeRepository;

    @InjectMocks
    private AnimalTypeService animalTypeService;

    @Test
    void create() {
        AnimalType animalTypeToCreate = new AnimalType();
        AnimalType savedAnimalType = new AnimalType();
        when(animalTypeRepository.save(animalTypeToCreate)).thenReturn(savedAnimalType);

        AnimalType result = animalTypeService.create(animalTypeToCreate);

        assertEquals(savedAnimalType, result);
    }

    @Test
    void findAll() {
        AnimalType animalType = new AnimalType();
        when(animalTypeRepository.findAll()).thenReturn(List.of(animalType, animalType));

        List<AnimalType> animalTypeList = animalTypeService.findAll();

        assertEquals(2, animalTypeList.size());
    }
}