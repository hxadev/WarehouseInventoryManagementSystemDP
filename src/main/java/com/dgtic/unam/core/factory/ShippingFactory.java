package com.dgtic.unam.core.factory;

import com.dgtic.unam.service.shipping.ShippingService;

/**
 * Abstract factory class for creating instances of ShippingService.
 * This class defines the method createService which must be implemented by subclasses.
 *
 * @author hxa.dev
 */
public abstract class ShippingFactory {
    public abstract ShippingService createService();
}
