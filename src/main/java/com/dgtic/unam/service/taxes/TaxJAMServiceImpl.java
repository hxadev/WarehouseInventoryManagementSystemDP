package com.dgtic.unam.service.taxes;

public class TaxJAMServiceImpl implements TaxServiceStrategy {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.16; // Example: 16% tax rate for Jamaica
    }
}
