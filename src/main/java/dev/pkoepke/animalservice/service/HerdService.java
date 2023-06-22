package dev.pkoepke.animalservice.service;

import dev.pkoepke.animalservice.domain.Group;
import dev.pkoepke.animalservice.domain.Herd;
import dev.pkoepke.animalservice.domain.entity.AnimalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Generates a randomizes herd.
 */
@Service
public class HerdService {

    private final AnimalTypeService animalTypeService;

    @Autowired
    public HerdService(AnimalTypeService animalTypeService) {
        this.animalTypeService = animalTypeService;
    }

    /**
     * Generates a randomized herd with groups for every available animalType.
     *
     * @param size size of the herd
     * @return generated herd
     */
    public Herd generateRandomDistributedHerd(int size) {
        List<AnimalType> allAnimalTypes = animalTypeService.findAll();

        int numberOfDifferentGroups = allAnimalTypes.size();
        List<Integer> randomSplitValues = split(size, numberOfDifferentGroups);

        Herd herd = new Herd();
        for (int i = 0; i < numberOfDifferentGroups; i++) {
            herd.getGroups().add(new Group(allAnimalTypes.get(i), randomSplitValues.get(i)));
        }

        return herd;
    }


    /**
     * Splits the input size into random chunks, which represent the count of the different groups.
     *
     * @param size                size of the herd
     * @param numberOfDifferentGroups number of different groups to split the herd into
     * @return List of the split herd counts.
     */
    protected List<Integer> split(int size, int numberOfDifferentGroups) {
        Random random = new Random();
        List<Integer> herd = new ArrayList<>();

        // Generate random size and add it to the herd
        for (int i = 0; i < numberOfDifferentGroups - 1; i++) {
            int maxGroupSize = size - (numberOfDifferentGroups - i - 1);
            int groupSize = random.nextInt(maxGroupSize) + 1;
            herd.add(groupSize);
            size -= groupSize;
        }

        // The last group size is the remaining herd size
        herd.add(size);

        // Shuffle the list to ensure the result is different each time
        Collections.shuffle(herd, random);

        return herd;
    }
}
