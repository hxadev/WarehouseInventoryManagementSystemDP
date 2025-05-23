package com.dgtic.unam.service.shippingCost;

public class WeightDistanceStrategy implements ShippingCostStrategy {
    @Override
    public double calculateShippingCost(double weight, double distance) {
        return weight * 2.0 + distance * 0.5;
    }
}
