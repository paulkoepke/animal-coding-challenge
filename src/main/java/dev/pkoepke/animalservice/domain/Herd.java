package dev.pkoepke.animalservice.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a number of different animal groups.
 */
@Getter
public class Herd {

    private final List<Group> groups;

    public Herd() {
        groups = new ArrayList<>();
    }
}
