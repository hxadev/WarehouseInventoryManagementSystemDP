package com.dgtic.unam.service.taxes;

/**
 * TaxServiceStrategy interface for the Strategy design pattern.
 * This interface defines a method for calculating taxes.
 * Classes implementing this interface should provide their own implementation of the calculateTax method.
 *
 * @author hxa.dev
 */
public interface TaxServiceStrategy {
    double calculateTax(double amount);
}
