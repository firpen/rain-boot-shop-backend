package com.rickard.rain_boot_webshop.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.rickard.rain_boot_webshop.services.StripePaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;



@RequestMapping("/stripe")
@RestController
public class StripePaymentController {

    private final StripePaymentService stripePaymentService;

    public StripePaymentController(StripePaymentService stripePaymentService) {
        this.stripePaymentService = stripePaymentService;
    }

    @PostMapping("/create-checkout-session")
    public ResponseEntity<String> postCreateCheckoutSession(@RequestBody Long cartId) throws StripeException {
        Session session = stripePaymentService.createCheckoutSession(cartId);
        return ResponseEntity.ok(session.getUrl());
    }

}
