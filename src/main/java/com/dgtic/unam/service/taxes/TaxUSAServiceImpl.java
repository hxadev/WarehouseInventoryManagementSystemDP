package com.dgtic.unam.service.taxes;

public class TaxUSAServiceImpl implements TaxServiceStrategy {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.07; // Example: 7% tax rate for USA
    }
}
