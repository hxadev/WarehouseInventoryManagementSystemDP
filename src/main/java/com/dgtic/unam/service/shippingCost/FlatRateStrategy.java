package com.dgtic.unam.service.shippingCost;

public class FlatRateStrategy implements ShippingCostStrategy{
    @Override
    public double calculateShippingCost(double weight, double distance) {
        return 50.0;
    }
}
