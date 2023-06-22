package dev.pkoepke.animalservice.converter;

import dev.pkoepke.animalservice.domain.Group;
import dev.pkoepke.animalservice.domain.Herd;
import dev.pkoepke.animalservice.domain.entity.AnimalType;
import dev.pkoepke.animalservice.dto.HerdDto;
import dev.pkoepke.animalservice.dto.GroupDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HerdToDtoConverterTest {
    @Mock
    private GroupToDtoConverter groupToDtoConverter;

    @InjectMocks
    private HerdToDtoConverter converter;


    @Test
    void converts() {
        Herd herd = new Herd();
        Group group = new Group(new AnimalType("LION"), 10);
        herd.getGroups().add(group);
        GroupDto groupDto = new GroupDto();
        when(groupToDtoConverter.convert(group)).thenReturn(groupDto);

        HerdDto result = converter.convert(herd);

        assertEquals(groupDto, result.getGroups().get(0));
    }
}