package dev.pkoepke.animalservice.facade;

import dev.pkoepke.animalservice.converter.AnimalTypeDtoToEntityConverter;
import dev.pkoepke.animalservice.converter.AnimalTypeToDtoConverter;
import dev.pkoepke.animalservice.domain.entity.AnimalType;
import dev.pkoepke.animalservice.dto.AnimalTypeDto;
import dev.pkoepke.animalservice.service.AnimalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Responsible for converting the input and output of the business logic layer.
 */
@Component
public class AnimalTypeFacade {

    private final AnimalTypeService animalTypeService;

    private final AnimalTypeDtoToEntityConverter animalTypeDtoToEntityConverter;

    private final AnimalTypeToDtoConverter animalTypeToDtoConverter;

    @Autowired
    public AnimalTypeFacade(
            AnimalTypeService animalTypeService,
            AnimalTypeDtoToEntityConverter animalTypeDtoToEntityConverter,
            AnimalTypeToDtoConverter animalTypeToDtoConverter
    ) {
        this.animalTypeService = animalTypeService;
        this.animalTypeDtoToEntityConverter = animalTypeDtoToEntityConverter;
        this.animalTypeToDtoConverter = animalTypeToDtoConverter;
    }

    /**
     * Creates a new AnimalType and returns it.
     *
     * @param animalTypeDto animalType to create
     * @return created animalType
     */
    public AnimalTypeDto create(AnimalTypeDto animalTypeDto) {
        AnimalType animalTypeToCreate = animalTypeDtoToEntityConverter.convert(animalTypeDto);
        AnimalType createdAnimalType = animalTypeService.create(animalTypeToCreate);
        return animalTypeToDtoConverter.convert(createdAnimalType);
    }
}
