package com.dgtic.unam.entity.prototype;

/**
 * ProductPrototype interface for the Prototype design pattern.
 * This interface defines a method for cloning objects.
 * Classes implementing this interface should provide their own implementation of the clone method.
 *
 * @author hxa.dev
 */
public interface ProductPrototype {
    ProductPrototype clone();
}
