package com.rickard.rain_boot_webshop.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rickard.rain_boot_webshop.dtos.CartDto;
import com.rickard.rain_boot_webshop.dtos.CartItemDto;
import com.stripe.StripeClient;
import com.stripe.param.checkout.SessionCreateParams;

import com.stripe.model.checkout.Session;
import com.stripe.exception.StripeException;

/* https://docs.stripe.com/checkout/quickstart
    docs.stripe.com/api/checkout/sessions/create */
@Service
public class StripePaymentService {

    @Value("${frontend.url}")
    String frontendUrl;

    @Value("${stripe.apiKey}")
    String stripeApiKey;

    private final CartService cartService;

    public StripePaymentService(CartService cartService) {
        this.cartService = cartService;
    }

    public Session createCheckoutSession(Long cartId) throws StripeException {

        CartDto cartDto = cartService.getCart(cartId);
        long sum = 0;
        for (CartItemDto cartItem : cartDto.cartItems()) {
            sum += (long) cartItem.quantity() * cartItem.product().price() * 100;
        }

        StripeClient client = new StripeClient(stripeApiKey);
        SessionCreateParams params = SessionCreateParams.builder()
                .setSuccessUrl(frontendUrl + "/stripe/success")
                .setCancelUrl(frontendUrl)
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency("sek")
                                                .setProductData(
                                                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                .setName("Varukorg").build())
                                                .setUnitAmount(sum).build())
                                .setQuantity(1L).build())
                .setMode(SessionCreateParams.Mode.PAYMENT).build();
        Session session = client.v1().checkout().sessions().create(params);
        return session;
    }

}
