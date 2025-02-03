package com.hng.stageone.numberclassificationapi.controller;

import com.hng.stageone.numberclassificationapi.dto.ErrorResponse;
import com.hng.stageone.numberclassificationapi.dto.NumberResponse;
import com.hng.stageone.numberclassificationapi.helpers.NumberHelpers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NumberClassification {
    // Endpoint: GET /api/classify-number?number=371

    @GetMapping("/classify-number")
    public ResponseEntity<?> classifyNumber(@RequestParam String number) {
        try {
            int parsedNumber = Integer.parseInt(number);
            if (parsedNumber <= 0) {
                return ResponseEntity.badRequest().body("Number must be greater than 0");
            }

            // Check if number is prime
            boolean isPrime = NumberHelpers.isPrime(parsedNumber);

            // Check if number is perfect
            boolean isPerfect = NumberHelpers.isPerfectNumber(parsedNumber);

            // Get sum of digits
            int sumOfDigits = NumberHelpers.sumOfDigits(parsedNumber);

            // Get number fact
            String funFact = NumberHelpers.numberFunFact(parsedNumber);

            List<String> properties = NumberHelpers.getProperties(parsedNumber);

            NumberResponse response = new NumberResponse(
                    parsedNumber,
                    isPrime,
                    isPerfect,
                    sumOfDigits,
                    funFact,
                    properties
            );

            return ResponseEntity.ok(response);
        } catch (NumberFormatException e) {
            ErrorResponse errorResponse = new ErrorResponse(number, true);
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
