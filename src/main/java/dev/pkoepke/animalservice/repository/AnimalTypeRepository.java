package dev.pkoepke.animalservice.repository;

import dev.pkoepke.animalservice.domain.entity.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository of AnimalType.
 */
@Repository
public interface AnimalTypeRepository extends JpaRepository<AnimalType, Long> {
}
