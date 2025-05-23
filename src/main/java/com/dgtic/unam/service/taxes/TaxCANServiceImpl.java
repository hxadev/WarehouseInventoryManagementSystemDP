package com.dgtic.unam.service.taxes;

public class TaxCANServiceImpl implements TaxServiceStrategy {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.05; // Example: 5% tax rate for Canada
    }
}
