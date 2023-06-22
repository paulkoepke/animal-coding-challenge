package dev.pkoepke.animalservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Wraps an error message to be sent to the client.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorResponseDto {

    private int statusCode;

    private String message;

}
