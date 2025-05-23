package com.dgtic.unam.service.shipping;

import com.dgtic.unam.entity.Order;

/**
 * ShippingService interface for the Factory Method design pattern.
 * This interface defines a method for shipping orders.
 * Classes implementing this interface should provide their own implementation of the ship method.
 *
 * @author hxa.dev
 */
public interface ShippingService {
    void ship(Order order);
}
