package com.example.vkbot1.controller;

import com.example.vkbot1.dto.Callback;
import com.example.vkbot1.service.CallbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vkbot")
@RequiredArgsConstructor
public class CallbackController {

    private final CallbackService callbackService;

    @PostMapping
    public ResponseEntity<String> handle(@RequestBody Callback callback) {
        return new ResponseEntity<>(callbackService.handleCallback(callback), HttpStatus.OK);
    }

}
