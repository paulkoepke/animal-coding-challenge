package dev.pkoepke.animalservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * DTO for a Herd.
 */
@Getter
@Setter
public class HerdDto {

    private List<GroupDto> groups;

}
