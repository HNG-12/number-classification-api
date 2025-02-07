package com.hng.stageone.numberclassificationapi.service;

import com.hng.stageone.numberclassificationapi.model.SuccessResponse;
import com.hng.stageone.numberclassificationapi.util.NumberHelpers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberClassificationService {
    public SuccessResponse classifyNumber(int number) {
        boolean isPrime = NumberHelpers.isPrime(number);
        boolean isPerfect = NumberHelpers.isPerfectNumber(number);
        int sumOfDigits = NumberHelpers.sumOfDigits(number);
        String funFact = NumberHelpers.numberFunFact(number);
        List<String> properties = NumberHelpers.getProperties(number);

        return new SuccessResponse(number, isPrime, isPerfect, sumOfDigits, funFact, properties);
    }
}
