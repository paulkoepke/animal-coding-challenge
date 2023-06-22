package dev.pkoepke.animalservice.controller.advice;

import dev.pkoepke.animalservice.dto.ErrorResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GlobalControllerAdviceTest {

    @Test
    void handlesAllOtherExceptions() {
        GlobalControllerAdvice globalControllerAdvice = new GlobalControllerAdvice();
        String testMessage = "test message";
        Exception testException = new Exception(testMessage);

        ResponseEntity<ErrorResponseDto> result = globalControllerAdvice.handleExceptions(
                testException);

        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getBody().getStatusCode());
        assertEquals(testMessage, result.getBody().getMessage());
    }

    @Test
    void handlesMethodArgumentNotValidException() {
        GlobalControllerAdvice globalControllerAdvice = new GlobalControllerAdvice();
        MethodArgumentNotValidException methodArgumentNotValidException = mock(
                MethodArgumentNotValidException.class);
        when(methodArgumentNotValidException.getFieldErrors()).thenReturn(List.of(
                        new FieldError("herdSize", "herdSize", "field must be lower than 1000"),
                        new FieldError("secondField", "secondField", "second invalid field")
                )
        );

        ResponseEntity<ErrorResponseDto> result = globalControllerAdvice.handleMethodArgumentNotValidException(
                methodArgumentNotValidException);

        assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(HttpStatus.BAD_REQUEST.value(), result.getBody().getStatusCode());
    }

}