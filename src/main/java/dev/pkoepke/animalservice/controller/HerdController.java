package dev.pkoepke.animalservice.controller;

import dev.pkoepke.animalservice.dto.HerdDto;
import dev.pkoepke.animalservice.facade.HerdFacade;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * REST Controller to get a randomized herd.
 */
@RestController
@RequestMapping("herd")
@Validated
public class HerdController {

    private final HerdFacade herdFacade;

    @Autowired
    public HerdController(HerdFacade herdFacade) {
        this.herdFacade = herdFacade;
    }

    /**
     * GET Route to get a randomized herd.
     *
     * @param size size of the herd
     * @return HerdDto
     */
    @Operation(summary = "Get a randomized herd.", description = "Get a randomized herd.")
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public HerdDto getHerd(@RequestParam @Min(1) @Max(1000) Integer size) {
        return herdFacade.getHerd(size);
    }
}
