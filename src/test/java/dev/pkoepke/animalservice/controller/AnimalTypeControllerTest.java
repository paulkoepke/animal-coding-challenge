package dev.pkoepke.animalservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.pkoepke.animalservice.dto.AnimalTypeDto;
import dev.pkoepke.animalservice.facade.AnimalTypeFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = AnimalTypeController.class)
@ExtendWith(MockitoExtension.class)
class AnimalTypeControllerTest {

    @MockBean
    private AnimalTypeFacade animalTypeFacade;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createAnimalType() throws Exception {
        String animalTypeName = "LION";
        ObjectMapper objectMapper = new ObjectMapper();
        AnimalTypeDto testAnimalTypeDto = new AnimalTypeDto();
        testAnimalTypeDto.setName(animalTypeName);
        when(animalTypeFacade.create(any(AnimalTypeDto.class))).thenReturn(testAnimalTypeDto);

        mockMvc.perform(post("/animaltype").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testAnimalTypeDto)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(
                        "$.name", is(animalTypeName)
                ));
    }


}