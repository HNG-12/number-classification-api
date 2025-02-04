package com.hng.stageone.numberclassificationapi.controller;

import com.hng.stageone.numberclassificationapi.model.ErrorResponse;
import com.hng.stageone.numberclassificationapi.model.NumberResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NumberClassificationTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private NumberClassification numberClassification;

    @Test
    void testClassifyNumber_ValidInput() {
        //when(restTemplate.getForObject(anyString(), anyString.class)).thenReturn("371 is an Armstrong number.");
        when(restTemplate.getForObject("http://localhost:8080/api/classify-number?number=371", String.class))
                .thenReturn("371 is an armstrong number, 371 is an odd number");


        ResponseEntity<?> response = numberClassification.classifyNumber("371");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertInstanceOf(NumberResponse.class, response.getBody());

        NumberResponse numberResponse = (NumberResponse) response.getBody();
        assertEquals(371, numberResponse.getNumber());
        assertFalse(numberResponse.isIs_prime());
        assertFalse(numberResponse.isIs_perfect());
        assertTrue(numberResponse.getProperties().contains("armstrong"));
        assertTrue(numberResponse.getProperties().contains("odd"));
        assertEquals(11, numberResponse.getDigit_sum());
        assertEquals("371 is an armstrong number", numberResponse.getFun_fact());
    }

    @Test
    void testClassifyNumber_InvalidInput() {
        ResponseEntity<?> response = numberClassification.classifyNumber("abc");

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).toString().contains("alphabet"));
        //assertTrue(response.getBody() instanceof ErrorResponse);

        ErrorResponse errorResponse = (ErrorResponse) response.getBody();
        assertEquals("alphabet", errorResponse.getNumber());
        assertTrue(errorResponse.isError());
    }
}
