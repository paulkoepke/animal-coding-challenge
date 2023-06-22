package dev.pkoepke.animalservice.facade;

import dev.pkoepke.animalservice.converter.Converter;
import dev.pkoepke.animalservice.domain.Herd;
import dev.pkoepke.animalservice.dto.HerdDto;
import dev.pkoepke.animalservice.service.HerdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Responsible for converting the input and output of the business logic layer.
 */
@Component
public class HerdFacade {

    private final HerdService herdService;

    private final Converter<Herd, HerdDto> herdToDtoConverter;

    @Autowired
    public HerdFacade(HerdService herdService, Converter<Herd, HerdDto> herdToDtoConverter) {
        this.herdService = herdService;
        this.herdToDtoConverter = herdToDtoConverter;
    }

    /**
     * Get a randomized herd.
     *
     * @param size size of the herd
     * @return HerdDto
     */
    public HerdDto getHerd(int size) {
        Herd herd = herdService.generateRandomDistributedHerd(size);
        return herdToDtoConverter.convert(herd);
    }


}
