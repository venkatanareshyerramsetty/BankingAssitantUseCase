package com.ness.BankingAssistant.controller;

import com.ness.BankingAssistant.dto.HealthCheckResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/api/health")
    public ResponseEntity<HealthCheckResponse> getApplicationHealth() {
        return new ResponseEntity<>(new HealthCheckResponse("UP", "SmartBanking-Assistant"), HttpStatus.OK);
    }
}
