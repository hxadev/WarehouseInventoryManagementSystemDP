package com.dgtic.unam.service.taxes;

public class TaxMxServiceImpl implements TaxServiceStrategy{
    @Override
    public double calculateTax(double amount) {
        return amount * 0.16; // Example: 16% tax rate
    }
}
