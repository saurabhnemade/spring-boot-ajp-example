package com.saurabhnemade.springbootajpexample.controller;

import com.saurabhnemade.springbootajpexample.ResponseObjects.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/status")
    public ResponseEntity getStatus() {
        Status responseStatus = new Status();
        responseStatus.setStatus("success");
        responseStatus.setMessage("Service is up and running. P.S. This endpoint is required for service monitoring");
        return ResponseEntity.ok(responseStatus);
    }
}
