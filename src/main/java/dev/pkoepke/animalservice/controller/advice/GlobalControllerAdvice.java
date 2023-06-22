package dev.pkoepke.animalservice.controller.advice;

import dev.pkoepke.animalservice.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * Global exception handler. Wraps error message in dto.
 */
@RestControllerAdvice
public class GlobalControllerAdvice {

    /**
     * Handles all exceptions that are not explicitly handled in a separate method and wraps error message in ErrorResponseDto.
     *
     * @param e exception to handle
     * @return ErrorResponseDto
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponseDto> handleExceptions(
            Exception e
    ) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }


    /**
     * Handles MethodArgumentNotValidException and prepares all argument errors to be wrapped in a ErrorResponseDto.
     *
     * @param ex MethodArgumentNotValidException
     * @return ErrorResponseDto
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex
    ) {
        // Extracting the error messages from the validation errors
        String errorMessage = ex.getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(), errorMessage);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}
