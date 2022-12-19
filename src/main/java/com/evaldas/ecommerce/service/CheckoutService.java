package com.evaldas.ecommerce.service;

import com.evaldas.ecommerce.dto.PaymentInfo;
import com.evaldas.ecommerce.dto.Purchase;
import com.evaldas.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
