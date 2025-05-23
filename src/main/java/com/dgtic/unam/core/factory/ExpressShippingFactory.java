package com.dgtic.unam.core.factory;

import com.dgtic.unam.service.shipping.ExpressShippingServiceImpl;
import com.dgtic.unam.service.shipping.ShippingService;

/**
 * Factory class for creating instances of ExpressShippingServiceImpl.
 * This class extends the ShippingFactory and overrides the createService method
 *
 * @author hxa.dev
 */
public class ExpressShippingFactory extends ShippingFactory {
    @Override
    public ShippingService createService() {
        return new ExpressShippingServiceImpl();
    }
}
