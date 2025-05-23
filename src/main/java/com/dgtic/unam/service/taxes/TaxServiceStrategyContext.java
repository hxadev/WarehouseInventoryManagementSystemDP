package com.dgtic.unam.service.taxes;


public class TaxServiceStrategyContext {
    private TaxServiceStrategy taxServiceStrategy;

    public TaxServiceStrategyContext() {
    }
    public void setTaxServiceStrategy(TaxServiceStrategy taxServiceStrategy) {
        this.taxServiceStrategy = taxServiceStrategy;
    }

    public double calculateTax(double amount) {
        return taxServiceStrategy.calculateTax(amount);
    }

}
