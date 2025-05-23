package com.dgtic.unam.controller;

import com.dgtic.unam.configuration.AuditServiceSingleton;
import com.dgtic.unam.core.constants.OrderType;
import com.dgtic.unam.entity.Order;
import com.dgtic.unam.facade.InventoryFacade;

/**
 * InventoryController is responsible for handling inventory-related operations.
 * It acts as a bridge between the user interface and the InventoryFacade.
 *
 * @author hxa.dev
 */
public class InventoryController {
    /**
     * The InventoryFacade instance used to perform inventory operations.
     */
    private final InventoryFacade inventoryFacade;

    /**
     * Constructor for InventoryController.
     *
     * @param inventoryFacade The InventoryFacade instance to be used.
     */
    public InventoryController(InventoryFacade inventoryFacade) {
        this.inventoryFacade = inventoryFacade;
    }

    /**
     * Places an order using the InventoryFacade.
     *
     * @param order     The order to be placed.
     * @param orderType The type of the order (e.g., online, in-store).
     */
    public void placeOrder(Order order, OrderType orderType) {
        // Here you would typically convert the orderId and orderType to the appropriate types
        // and create an Order object. For simplicity, we'll just print them.
        AuditServiceSingleton.getInstance().log("User", "placeOrder", "Placing order with ID: " + order.getOrderId() + " of type: " + orderType);
        // Call the facade to place the order
        inventoryFacade.placeOrder(order, orderType);
    }
}
