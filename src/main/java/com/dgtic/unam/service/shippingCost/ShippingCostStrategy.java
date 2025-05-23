package com.dgtic.unam.service.shippingCost;

public interface ShippingCostStrategy {
    /**
     * Calculate the shipping cost based on the weight and distance.
     *
     * @param weight   The weight of the package.
     * @param distance The distance to be shipped.
     * @return The calculated shipping cost.
     */
    double calculateShippingCost(double weight, double distance);

}
