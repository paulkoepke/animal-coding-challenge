package dev.pkoepke.animalservice.facade;

import dev.pkoepke.animalservice.converter.Converter;
import dev.pkoepke.animalservice.domain.Herd;
import dev.pkoepke.animalservice.dto.HerdDto;
import dev.pkoepke.animalservice.service.HerdService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HerdFacadeTest {
    @Mock
    private HerdService herdService;
    @Mock
    private Converter<Herd, HerdDto> herdToDtoConverter;
    @InjectMocks
    private HerdFacade herdFacade;

    @Test
    void getHerd() {
        Herd herd = new Herd();
        int herdSize = 100;
        HerdDto herdDto = new HerdDto();
        when(herdService.generateRandomDistributedHerd(herdSize)).thenReturn(herd);
        when(herdToDtoConverter.convert(herd)).thenReturn(herdDto);

        HerdDto result = herdFacade.getHerd(herdSize);

        assertEquals(herdDto, result);
    }
}