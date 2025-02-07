package com.hng.stageone.numberclassificationapi.controller;

import com.hng.stageone.numberclassificationapi.model.ErrorResponse;
import com.hng.stageone.numberclassificationapi.model.SuccessResponse;
import com.hng.stageone.numberclassificationapi.service.NumberClassificationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NumberClassificationControllerTest {

    @Mock
    private NumberClassificationService numberClassificationService;

    @InjectMocks
    private NumberClassificationController numberClassificationController;

    @Test
    void testClassifyNumber_ValidInput() {
        SuccessResponse mockSuccessResponse = new SuccessResponse(371, false, false, 11, "371 is an armstrong number", List.of("armstrong", "odd"));
        when(numberClassificationService.classifyNumber(371)).thenReturn(mockSuccessResponse);

        ResponseEntity<?> response = numberClassificationController.classifyNumber("371");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertInstanceOf(SuccessResponse.class, response.getBody());
    }

    @Test
    void testClassifyNumber_InvalidInput() {
        ResponseEntity<?> response = numberClassificationController.classifyNumber("abc");

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertInstanceOf(ErrorResponse.class, response.getBody());

        ErrorResponse errorResponse = (ErrorResponse) response.getBody();
        assertEquals("alphabet", errorResponse.getNumber());
        assertTrue(errorResponse.isError());
    }
}