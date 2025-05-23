package com.dgtic.unam.facade;

import com.dgtic.unam.core.constants.OrderType;
import com.dgtic.unam.core.factory.ShippingFactory;
import com.dgtic.unam.entity.Order;

/**
 * InventoryFacade is a facade class that simplifies the process of placing orders
 * by providing a unified interface to the underlying shipping services.
 * It uses the Factory design pattern to create instances of different shipping services.
 *
 * @author hxa.dev
 */
public class InventoryFacade {
    private final ShippingFactory expressShippingFactory;
    private final ShippingFactory groundShippingFactory;

    public InventoryFacade(ShippingFactory expressShippingFactory, ShippingFactory groundShippingFactory) {
        this.expressShippingFactory = expressShippingFactory;
        this.groundShippingFactory = groundShippingFactory;
    }

    public void placeOrder(Order order, OrderType orderType) {

        if (orderType == OrderType.EXPRESS_ORDER) {
            expressShippingFactory.createService().ship(order);
        } else if (orderType == OrderType.STANDARD_ORDER) {
            groundShippingFactory.createService().ship(order);
        } else {
            throw new IllegalArgumentException("Invalid order type: " + orderType);
        }
    }
}
