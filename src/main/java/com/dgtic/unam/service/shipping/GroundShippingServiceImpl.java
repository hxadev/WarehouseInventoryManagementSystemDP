package com.dgtic.unam.service.shipping;

import com.dgtic.unam.entity.Order;

/**
 * GroundShippingServiceImpl class implements the ShippingService interface.
 * This class provides an implementation for shipping orders using ground shipping.
 * It also includes a method to store the shipping information in the database.
 *
 * @author hxa.dev
 */
public class GroundShippingServiceImpl implements ShippingService {
    @Override
    public void ship(Order order) {
        System.out.println("Shipping order " + order.getOrderId() + " using ground shipping.");
        System.out.println("Shipping stored in the database.");

    }
}
