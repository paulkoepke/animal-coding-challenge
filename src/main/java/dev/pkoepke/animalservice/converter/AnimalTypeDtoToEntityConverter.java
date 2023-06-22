package dev.pkoepke.animalservice.converter;

import dev.pkoepke.animalservice.domain.entity.AnimalType;
import dev.pkoepke.animalservice.dto.AnimalTypeDto;
import org.springframework.stereotype.Component;

/**
 * Converts AnimalTypeDto to AnimalType.
 */
@Component
public class AnimalTypeDtoToEntityConverter implements Converter<AnimalTypeDto, AnimalType> {

    /**
     * Converts AnimalTypeDto to AnimalType.
     *
     * @param source AnimalTypeDto source to convert from
     * @return result AnimalType
     */
    @Override
    public AnimalType convert(AnimalTypeDto source) {
        return new AnimalType(source.getName());
    }
}
