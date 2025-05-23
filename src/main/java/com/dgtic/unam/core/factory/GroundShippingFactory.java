package com.dgtic.unam.core.factory;

import com.dgtic.unam.service.shipping.GroundShippingServiceImpl;
import com.dgtic.unam.service.shipping.ShippingService;

/**
 * Factory class for creating instances of GroundShippingServiceImpl.
 * This class extends the ShippingFactory and overrides the createService method
 *
 * @author hxa.dev
 */
public class GroundShippingFactory extends ShippingFactory {
    @Override
    public ShippingService createService() {
        return new GroundShippingServiceImpl();
    }
}
