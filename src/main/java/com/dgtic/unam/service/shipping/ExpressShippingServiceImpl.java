package com.dgtic.unam.service.shipping;

import com.dgtic.unam.entity.Order;

/**
 * ExpressShippingServiceImpl class implements the ShippingService interface.
 * This class provides an implementation for shipping orders using express shipping.
 * It also includes a method to store the shipping information in the database.
 *
 * @author hxa.dev
 */
public class ExpressShippingServiceImpl implements ShippingService {
    @Override
    public void ship(Order order) {
        System.out.println("Shipping order " + order.getOrderId() + " using express shipping.");
        System.out.println("Shipping stored in the database.");
    }
}
