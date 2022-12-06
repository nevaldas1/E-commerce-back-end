package com.evaldas.ecommerce.service;

import com.evaldas.ecommerce.dto.Purchase;
import com.evaldas.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder (Purchase purchase);
}
