package com.hng.stageone.numberclassificationapi.controller;

import com.hng.stageone.numberclassificationapi.model.ErrorResponse;
import com.hng.stageone.numberclassificationapi.model.SuccessResponse;
import com.hng.stageone.numberclassificationapi.service.NumberClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NumberClassificationController {
    private final NumberClassificationService numberClassificationService;

    @Autowired
    public NumberClassificationController(NumberClassificationService numberClassificationService) {
        this.numberClassificationService = numberClassificationService;
    }

    @GetMapping("/classify-number")
    public ResponseEntity<?> classifyNumber(@RequestParam String number) {
        try {
            int parsedNumber = Integer.parseInt(number);
            SuccessResponse response = numberClassificationService.classifyNumber(parsedNumber);
            return ResponseEntity.ok(response);
        } catch (NumberFormatException e) {
            ErrorResponse errorResponse = new ErrorResponse("alphabet", true);
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
