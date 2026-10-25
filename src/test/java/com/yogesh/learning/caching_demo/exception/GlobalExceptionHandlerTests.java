package com.yogesh.learning.caching_demo.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GlobalExceptionHandlerTests {

    @Test
    void returnsNotFoundProblemDetailForMissingProduct() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();
        ProductNotFoundException exception = new ProductNotFoundException(42L);

        ResponseEntity<ProblemDetail> response =
                handler.handleProductNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Product not found", response.getBody().getTitle());
        assertEquals("Product not found with id: 42", response.getBody().getDetail());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getBody().getStatus());
    }
}
