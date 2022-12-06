package com.evaldas.ecommerce.dto;

import com.evaldas.ecommerce.entity.Address;
import com.evaldas.ecommerce.entity.Customer;
import com.evaldas.ecommerce.entity.Order;
import com.evaldas.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;
}
