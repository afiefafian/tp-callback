package com.github.afiefafian.tpcallback.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/callback/order")
public class CallbackController {
    @PostMapping("/notification")
    public ResponseEntity<String> order_notification(
            @RequestHeader Map<String, String> headers,
            @RequestBody String bodyData
    ) {
        System.out.println("Order Notification");
        System.out.println(headers);
        System.out.println(bodyData);
        return new ResponseEntity<>(bodyData, HttpStatus.OK);
    }

    @PostMapping("/actions")
    public ResponseEntity<String> order_actions(
            @RequestHeader Map<String, String> headers,
            @RequestBody String bodyData
    ) {
        System.out.println("Order Actions");
        System.out.println(headers);
        System.out.println(bodyData);
        return new ResponseEntity<>(bodyData, HttpStatus.OK);
    }

    @PostMapping("/cancellation")
    public ResponseEntity<String> order_cancellation(
            @RequestHeader Map<String, String> headers,
            @RequestBody String bodyData
    ) {
        System.out.println("Order Cancellation");
        System.out.println(headers);
        System.out.println(bodyData);
        return new ResponseEntity<>(bodyData, HttpStatus.OK);
    }

    @PostMapping("/status")
    public ResponseEntity<String> order_status(
            @RequestHeader Map<String, String> headers,
            @RequestBody String bodyData
    ) {
        System.out.println("Order Status");
        System.out.println(headers);
        System.out.println(bodyData);
        return new ResponseEntity<>(bodyData, HttpStatus.OK);
    }
}
