package dev.pkoepke.animalservice.controller;

import dev.pkoepke.animalservice.dto.AnimalTypeDto;
import dev.pkoepke.animalservice.facade.AnimalTypeFacade;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * REST Controller to create new animal types.
 */
@RestController
@RequestMapping("animaltype")
@Validated
public class AnimalTypeController {

    private final AnimalTypeFacade animalTypeFacade;

    @Autowired
    public AnimalTypeController(AnimalTypeFacade animalTypeFacade) {
        this.animalTypeFacade = animalTypeFacade;
    }

    /**
     * POST Route to create a new AnimalType.
     *
     * @param animalTypeDto animalType to create
     * @return created animalType
     */
    @Operation(summary = "Create a new AnimalType.", description = "Create a new AnimalType.")
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public AnimalTypeDto createAnimalType(@RequestBody @Valid AnimalTypeDto animalTypeDto) {
        return animalTypeFacade.create(animalTypeDto);
    }
}
