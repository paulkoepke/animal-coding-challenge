package dev.pkoepke.animalservice.service;

import dev.pkoepke.animalservice.domain.entity.AnimalType;
import dev.pkoepke.animalservice.repository.AnimalTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for creating and finding AnimalTypes.
 */
@Service
public class AnimalTypeService {

    private final AnimalTypeRepository animalTypeRepository;

    @Autowired
    public AnimalTypeService(AnimalTypeRepository animalTypeRepository) {
        this.animalTypeRepository = animalTypeRepository;
    }

    /**
     * Creates a new AnimalType and returns it.
     *
     * @param animalType AnimalType to create
     * @return created AnimalType
     */
    public AnimalType create(AnimalType animalType) {
        return animalTypeRepository.save(animalType);
    }

    /**
     * Finds all available AnimalTypes in the database.
     *
     * @return List of all AnimalTypes
     */
    public List<AnimalType> findAll() {
        return animalTypeRepository.findAll();
    }
}
