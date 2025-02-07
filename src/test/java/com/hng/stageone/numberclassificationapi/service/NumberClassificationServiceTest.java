package com.hng.stageone.numberclassificationapi.service;

import com.hng.stageone.numberclassificationapi.model.SuccessResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberClassificationServiceTest {

    private final NumberClassificationService numberClassificationService = new NumberClassificationService();

    @Test
    void testClassifyNumber() {
        SuccessResponse response = numberClassificationService.classifyNumber(371);

        assertEquals(371, response.getNumber());
        assertFalse(response.isIs_prime());
        assertFalse(response.isIs_perfect());
        assertEquals(11, response.getDigit_sum());
        assertNotNull(response.getFun_fact());
        assertTrue(response.getProperties().contains("armstrong"));
        assertTrue(response.getProperties().contains("odd"));
    }
}
