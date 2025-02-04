package com.hng.stageone.numberclassificationapi.controller;

import com.hng.stageone.numberclassificationapi.model.ErrorResponse;
import com.hng.stageone.numberclassificationapi.model.NumberResponse;
import com.hng.stageone.numberclassificationapi.util.NumberHelpers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NumberClassification {

    @GetMapping("/classify-number")
    public ResponseEntity<?> classifyNumber(@RequestParam String number) {
        try {
            int parsedNumber = Integer.parseInt(number);

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
            ErrorResponse errorResponse = new ErrorResponse("alphabet", true);
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
