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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NumberClassificationTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private NumberClassification numberClassification;

    @Test
    void testClassifyNumber_ValidInput() {

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
        assertNotNull(numberResponse.getFun_fact());
    }

    @Test
    void testClassifyNumber_InvalidInput() {
        ResponseEntity<?> response = numberClassification.classifyNumber("abc");

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertInstanceOf(ErrorResponse.class, response.getBody());

        ErrorResponse errorResponse = (ErrorResponse) response.getBody();
        assertEquals("alphabet", errorResponse.getNumber());
        assertTrue(errorResponse.isError());
    }
}
