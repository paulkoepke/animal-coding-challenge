package dev.pkoepke.animalservice.controller;

import dev.pkoepke.animalservice.dto.HerdDto;
import dev.pkoepke.animalservice.dto.AnimalTypeDto;
import dev.pkoepke.animalservice.dto.GroupDto;
import dev.pkoepke.animalservice.facade.HerdFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = HerdController.class)
@ExtendWith(MockitoExtension.class)
class HerdControllerTest {

    @MockBean
    private HerdFacade herdFacade;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getHerd() throws Exception {
        HerdDto testHerdDto = generateTestHerdDto();
        when(herdFacade.getHerd(100)).thenReturn(testHerdDto);

        mockMvc.perform(get("/herd").param("size", "100"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(
                        "$.groups[0].animalType.name",
                        is(testHerdDto.getGroups().get(0).getAnimalType().getName())
                ))
                .andExpect(jsonPath("$.groups[0].count", is(testHerdDto.getGroups().get(0).getCount())));

    }

    private HerdDto generateTestHerdDto() {
        HerdDto herdDto = new HerdDto();
        GroupDto groupDto = new GroupDto();
        AnimalTypeDto animalTypeDto = new AnimalTypeDto();
        animalTypeDto.setName("LION");
        groupDto.setAnimalType(animalTypeDto);
        groupDto.setCount(10);
        herdDto.setGroups(List.of(groupDto));
        return herdDto;
    }
}