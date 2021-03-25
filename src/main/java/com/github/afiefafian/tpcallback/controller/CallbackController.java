package com.github.afiefafian.tpcallback.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;

@RestController
@RequestMapping("/tokopedia/callback/order/")
public class CallbackController {

    static final String YOUR_WEBHOOK_SECRET = "abracadabr@";

    @PostMapping("test-hmac")
    public String test_hmac(@RequestBody String body, @RequestHeader("Authorization-Hmac") String actual) {
        try {
            // Encrypt the request body with your webhook secret
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(YOUR_WEBHOOK_SECRET.getBytes(), "HmacSHA256");
            mac.init(secret_key);

            // Encode it to hexadecimal
            byte[] hash = mac.doFinal(body.getBytes());
            StringBuilder expected = new StringBuilder();
            for (byte b : hash) {
                expected.append(String.format("%02x", b));
            }

            // Compare our HMAC with your HMAC
            if(!actual.equals(expected.toString())) {
                System.out.println("Failed to verify!");
                return "";
            }
            System.out.println("Successfully verified!");
        } catch (Exception e) {
            // Handle Exception
        }
        return "";
    }

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
