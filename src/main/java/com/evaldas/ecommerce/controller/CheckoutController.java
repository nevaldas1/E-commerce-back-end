package com.evaldas.ecommerce.controller;

import com.evaldas.ecommerce.dto.Purchase;
import com.evaldas.ecommerce.dto.PurchaseResponse;
import com.evaldas.ecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {


    private CheckoutService checkoutService;

    @Autowired   // Optional as single constructor
    public CheckoutController (CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}
