package com.dgtic.unam.service.shippingCost;

public class ShippingCostStrategyContext {
    private ShippingCostStrategy shippingCostStrategy;

    public ShippingCostStrategyContext() {
    }

    public void setShippingCostStrategy(ShippingCostStrategy shippingCostStrategy) {
        this.shippingCostStrategy = shippingCostStrategy;
    }

    public double calculateShippingCost(double weight, double distance) {
        return shippingCostStrategy.calculateShippingCost(weight, distance);
    }
}
