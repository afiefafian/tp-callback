package com.github.afiefafian.tpcallback.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/callback")
public class CallbackController {
    @PostMapping("order/notification")
    public ResponseEntity<String> order_notification(@RequestBody String bodyData) {
        System.out.println("Order Notification");
        System.out.println(bodyData);
        return new ResponseEntity<>(bodyData, HttpStatus.OK);
    }

    @PostMapping("order/actions")
    public ResponseEntity<String> order_actions(@RequestBody String bodyData) {
        System.out.println("Order Actions");
        System.out.println(bodyData);
        return new ResponseEntity<>(bodyData, HttpStatus.OK);
    }

    @PostMapping("order/cancellation")
    public ResponseEntity<String> order_cancellation(@RequestBody String bodyData) {
        System.out.println("Order Cancellation");
        System.out.println(bodyData);
        return new ResponseEntity<>(bodyData, HttpStatus.OK);
    }

    @PostMapping("order/status")
    public ResponseEntity<String> order_status(@RequestBody String bodyData) {
        System.out.println("Order Status");
        System.out.println(bodyData);
        return new ResponseEntity<>(bodyData, HttpStatus.OK);
    }
}
