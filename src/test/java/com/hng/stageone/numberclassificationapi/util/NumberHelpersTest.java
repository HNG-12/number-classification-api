package com.hng.stageone.numberclassificationapi.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberHelpersTest {

    @Test
    void testIsPerfectNumber() {
        assertTrue(NumberHelpers.isPerfectNumber(6));
        assertTrue(NumberHelpers.isPerfectNumber(28));
        assertTrue(NumberHelpers.isPerfectNumber(496));
        assertTrue(NumberHelpers.isPerfectNumber(8128));
        assertTrue(NumberHelpers.isPerfectNumber(33550336));
        assertFalse(NumberHelpers.isPerfectNumber(5));
        assertFalse(NumberHelpers.isPerfectNumber(10));
    }

    @Test
    void testIsPrimeNumber() {
        assertTrue(NumberHelpers.isPrime(2));
        assertTrue(NumberHelpers.isPrime(3));
        assertTrue(NumberHelpers.isPrime(5));
        assertFalse(NumberHelpers.isPrime(4));
        assertFalse(NumberHelpers.isPrime(6));
    }

    @Test
    void testIsArmstrongNumber() {
        assertTrue(NumberHelpers.isArmstrongNumber(153));
        assertTrue(NumberHelpers.isArmstrongNumber(371));
        assertTrue(NumberHelpers.isArmstrongNumber(9474));
        assertFalse(NumberHelpers.isArmstrongNumber(123));
        assertFalse(NumberHelpers.isArmstrongNumber(10));
    }

    @Test
    void testDigitSum() {
        assertEquals(6, NumberHelpers.sumOfDigits(123));
        assertEquals(10, NumberHelpers.sumOfDigits(1234));
        assertEquals(15, NumberHelpers.sumOfDigits(12345));
        assertNotEquals(11, NumberHelpers.sumOfDigits(123));
    }

    @Test
    void testGetProperties() {
        List<String> properties = NumberHelpers.getProperties(153);
        assertTrue(properties.contains("armstrong"));
        assertTrue(properties.contains("odd"));

        properties = NumberHelpers.getProperties(370);
        assertTrue(properties.contains("armstrong"));
        assertTrue(properties.contains("even"));

        properties = NumberHelpers.getProperties(15);
        assertTrue(properties.contains("odd"));
        assertFalse(properties.contains("armstrong"));
    }
}
