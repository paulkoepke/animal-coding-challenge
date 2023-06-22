package dev.pkoepke.animalservice.converter;

import dev.pkoepke.animalservice.domain.Group;
import dev.pkoepke.animalservice.domain.entity.AnimalType;
import dev.pkoepke.animalservice.dto.AnimalTypeDto;
import dev.pkoepke.animalservice.dto.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Converts Group to GroupDto.
 */
@Component
public class GroupToDtoConverter implements Converter<Group, GroupDto> {

    private final Converter<AnimalType, AnimalTypeDto> animalTypeToDtoConverter;

    @Autowired
    public GroupToDtoConverter(Converter<AnimalType, AnimalTypeDto> animalTypeToDtoConverter) {
        this.animalTypeToDtoConverter = animalTypeToDtoConverter;
    }

    /**
     * Converts Group to GroupDto.
     *
     * @param source source to convert from
     * @return result GroupDto
     */
    @Override
    public GroupDto convert(Group source) {
        GroupDto groupDto = new GroupDto();
        groupDto.setCount(source.getCount());
        groupDto.setAnimalType(animalTypeToDtoConverter.convert(source.getAnimalType()));
        return groupDto;
    }
}
