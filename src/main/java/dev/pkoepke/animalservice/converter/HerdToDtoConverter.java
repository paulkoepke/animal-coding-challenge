package dev.pkoepke.animalservice.converter;

import dev.pkoepke.animalservice.domain.Group;
import dev.pkoepke.animalservice.domain.Herd;
import dev.pkoepke.animalservice.dto.HerdDto;
import dev.pkoepke.animalservice.dto.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Converts Herd to HerdDto.
 */
@Component
public class HerdToDtoConverter implements Converter<Herd, HerdDto> {

    private final Converter<Group, GroupDto> groupToDtoConverter;

    @Autowired
    public HerdToDtoConverter(Converter<Group, GroupDto> groupToDtoConverter) {
        this.groupToDtoConverter = groupToDtoConverter;
    }

    /**
     * Converts Herd to HerdDto.
     *
     * @param herd source to convert from
     * @return result HerdDto
     */
    @Override
    public HerdDto convert(Herd herd) {
        HerdDto herdDto = new HerdDto();
        List<GroupDto> groupDtos = herd.getGroups().stream().map(groupToDtoConverter::convert).toList();
        herdDto.setGroups(groupDtos);
        return herdDto;
    }
}
