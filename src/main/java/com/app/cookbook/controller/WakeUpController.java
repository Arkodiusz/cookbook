package com.app.cookbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class WakeUpController {

    @GetMapping("/wakeup")
    public ResponseEntity<String> wakeUp() {
        return new ResponseEntity<>("CooKBook app is awake", HttpStatus.OK);
    }
}
