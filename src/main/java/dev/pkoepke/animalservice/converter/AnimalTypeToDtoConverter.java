package dev.pkoepke.animalservice.converter;

import dev.pkoepke.animalservice.domain.entity.AnimalType;
import dev.pkoepke.animalservice.dto.AnimalTypeDto;
import org.springframework.stereotype.Component;

/**
 * Converts SoldierType to SoldierTypeDto.
 */
@Component
public class AnimalTypeToDtoConverter implements Converter<AnimalType, AnimalTypeDto> {

    /**
     * Converts SoldierType to SoldierTypeDto.
     *
     * @param source SoldierType source to convert from
     * @return result SoldierTypeDto
     */
    @Override
    public AnimalTypeDto convert(AnimalType source) {
        AnimalTypeDto animalTypeDto = new AnimalTypeDto();
        animalTypeDto.setId(source.getId());
        animalTypeDto.setName(source.getName());
        return animalTypeDto;
    }
}
