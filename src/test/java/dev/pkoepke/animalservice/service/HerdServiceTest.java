package dev.pkoepke.animalservice.service;

import dev.pkoepke.animalservice.domain.Herd;
import dev.pkoepke.animalservice.domain.Group;
import dev.pkoepke.animalservice.domain.entity.AnimalType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HerdServiceTest {
    @Mock
    private AnimalTypeService animalTypeService;
    @InjectMocks
    private HerdService herdService;

    private static Stream<Arguments> provideRandomNumberSplitTestNumbers() {
        return Stream.of(
                Arguments.of(3, 3),
                Arguments.of(10, 1),
                Arguments.of(20, 3),
                Arguments.of(50, 5),
                Arguments.of(164, 7),
                Arguments.of(189, 12),
                Arguments.of(300, 14),
                Arguments.of(232, 14),
                Arguments.of(123, 14),
                Arguments.of(423, 14)
        );
    }


    @ParameterizedTest()
    @MethodSource("provideRandomNumberSplitTestNumbers")
    void generateRandomNumberSplit(int herdSize, int numberOfDifferentGroups) {
        List<Integer> split = herdService.split(herdSize, numberOfDifferentGroups);
        int splitSum = split.stream().mapToInt(Integer::intValue).sum();

        //makes sure there is an element for every group
        assertEquals(numberOfDifferentGroups, split.size());

        //makes sure the group sizes summed up are exactly the herd size
        assertEquals(herdSize, splitSum);

        //makes sure no group has the size 0
        assertTrue(split.stream().noneMatch(el -> el == 0));
    }

    @Test
    void generateRandomDistributedHerd() {
        when(animalTypeService.findAll())
                .thenReturn(List.of(new AnimalType("LION"), new AnimalType("ELEPHANT")));
        int herdSize = 100;

        Herd herd = herdService.generateRandomDistributedHerd(herdSize);

        assertEquals(2, herd.getGroups().size());
        assertEquals(herdSize, herd.getGroups().stream().map(Group::getCount).mapToInt(Integer::intValue).sum());
        assertEquals(
                1,
                herd.getGroups().stream().filter(group -> group.getAnimalType().getName().equals("LION")).count()
        );
        assertEquals(
                1,
                herd.getGroups().stream().filter(group -> group.getAnimalType().getName().equals("ELEPHANT")).count()
        );

    }
}