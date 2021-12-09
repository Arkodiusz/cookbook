package com.app.cookbook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class WakeUpController {

    @GetMapping("/wakeup")
    public ResponseEntity<String> wakeUp() {
        return ResponseEntity.ok("\"CooKBook app is awake\"");
    }
}
