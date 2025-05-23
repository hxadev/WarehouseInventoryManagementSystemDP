package com.dgtic.unam;

import com.dgtic.unam.configuration.AppConfigSingleton;
import com.dgtic.unam.configuration.AuditServiceSingleton;
import com.dgtic.unam.controller.InventoryController;
import com.dgtic.unam.core.constants.OrderType;
import com.dgtic.unam.core.factory.ExpressShippingFactory;
import com.dgtic.unam.core.factory.GroundShippingFactory;
import com.dgtic.unam.entity.Order;
import com.dgtic.unam.entity.Product;
import com.dgtic.unam.entity.prototype.ProductPrototype;
import com.dgtic.unam.facade.InventoryFacade;
import com.dgtic.unam.service.taxes.*;

import java.util.*;

/**
 * Main class for the Inventory Management System.
 *
 * @author hxa.dev
 */
public class Main {

    /**
     * Main method to start the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        startApp();
    }

    /**
     * Starts the application by loading configurations, products, and displaying the main menu.
     */
    public static void startApp() {

        printHeader();
        loadConfigurations();
        Map<Integer, Product> products = loadProducts();
        loadMainMenu(products);
        System.out.println("Thank you for using the Inventory Management System!");
        System.out.println("Exiting...");
        System.exit(0);
    }

    /**
     * Prints the header of the application.
     */
    public static void printHeader() {
        System.out.println("=============================================");
        System.out.println("Welcome to the Inventory Management System");
        System.out.println("=============================================");
        AuditServiceSingleton.getInstance().log("User", "printHeader", "Displayed header");
    }

    /**
     * Loads configurations from the AppConfigSingleton.
     */
    public static void loadConfigurations() {
        System.out.println("Loading configurations...");
        Map<String, String> configurations = AppConfigSingleton.getInstance().getConfigurations();

        for (Map.Entry<String, String> entry : configurations.entrySet()) {
            System.out.println("Configuration: " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Configurations loaded successfully.");
    }

    /**
     * Loads products into the system.
     *
     * @return a map of products with their IDs as keys
     */
    public static Map<Integer, Product> loadProducts() {
        System.out.println("Loading products...");
        Product baseProduct = new Product();
        Map<Integer, Product> products = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            ProductPrototype product = baseProduct.clone();
            ((Product) product).setId(i);
            ((Product) product).setCategory("Category " + i);
            ((Product) product).setName("Product " + i);
            ((Product) product).setDescription("Description for Product " + i);
            ((Product) product).setImage("image" + i + ".jpg");
            ((Product) product).setActive(true);
            ((Product) product).setDeliveryTime(5);
            ((Product) product).setBasePrice(100.0 + i * 10);
            ((Product) product).setStock(50 - i);

            products.put(i, (Product) product);
        }


        System.out.println("Products loaded successfully.");

        return products;
    }

    /**
     * Displays the main menu and handles user input.
     *
     * @param products a map of products
     */
    public static void loadMainMenu(Map<Integer, Product> products) {
        List<Product> cart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. View Products");
            System.out.println("2. Exit");
            System.out.print("Select an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    loadSelectProductMenu(products, cart);
                    break;
                case "2":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Displays the product selection menu and handles user input.
     * Options are to view product details, add to cart, checkout, or exit.
     *
     * @param products a map of products
     * @param cart     a list representing the shopping cart
     */
    public static void loadSelectProductMenu(Map<Integer, Product> products, List<Product> cart) {
        products.entrySet().forEach(entry -> {
            System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue().getName() +
                    ", Price: " + entry.getValue().getBasePrice() +
                    ", Stock: " + entry.getValue().getStock());
        });
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. View Product Details");
            System.out.println("2. Add to Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Enter Product ID to view details: ");
                    try {
                        int productId = Integer.parseInt(scanner.nextLine());
                        Product product = products.get(productId);
                        if (product != null) {
                            System.out.println(product);
                        } else {
                            System.out.println("Product not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Product ID.");
                    }
                    break;
                case "2":
                    System.out.print("Enter Product ID to add to cart: ");
                    try {
                        int productId = Integer.parseInt(scanner.nextLine());
                        Product product = products.get(productId);
                        if (product != null) {
                            if (product.getStock() > 0) {
                                cart.add(product);
                                product.setStock(product.getStock() - 1);
                                System.out.println(product.getName() + " added to cart.");
                            } else {
                                System.out.println("Product out of stock.");
                            }
                        } else {
                            System.out.println("Product not found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Product ID.");
                    }
                    break;
                case "3":
                    System.out.println("Checkout:");
                    checkout(cart);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Handles the checkout process, including tax calculation and order placement.
     *
     * @param cart a list representing the shopping cart
     */
    public static void checkout(List<Product> cart) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter you Country(MX,USA,CAN,JAM): ");
        String country = scanner.nextLine();
        System.out.print("Enter your shipping option: 1. Ground 2. Express: ");
        String shippingMethod = scanner.nextLine();

        System.out.print("Any special instructions? (leave blank if none): ");
        String specialInstructions = scanner.nextLine();

        System.out.println("Calculating total...");
        double subtotal = cart.stream().mapToDouble(Product::getBasePrice).sum();
        TaxServiceStrategyContext taxContext = getTaxServiceStrategyContext(country);
        double tax = taxContext.calculateTax(subtotal);
        double total = subtotal + tax;

        System.out.println("Creating order...");
        Order order = new Order.Builder()
                .orderId(new Random().nextInt(10000))
                .customerName(customerName)
                .orderDate(new Date())
                .totalAmount(total)
                .products(new ArrayList<>(cart))
                .specialInstructions(specialInstructions)
                .build();

        InventoryController inventoryController = getInventoryController();
        inventoryController.placeOrder(order, getOrderType(shippingMethod));

        System.out.println("Order placed successfully!");
        System.out.println(order);
        System.out.printf("Subtotal: $%.2f\nTax: $%.2f\nTotal: $%.2f\n", subtotal, tax, total);

        cart.clear();

    }

    /**
     * Returns the appropriate TaxServiceStrategyContext based on the country.
     *
     * @param country the country code
     * @return a TaxServiceStrategyContext instance
     */
    private static TaxServiceStrategyContext getTaxServiceStrategyContext(String country) {
        TaxServiceStrategyContext taxContext = new TaxServiceStrategyContext();
        if (country.equalsIgnoreCase("MX")) {
            taxContext.setTaxServiceStrategy(new TaxMxServiceImpl());
        } else if (country.equalsIgnoreCase("CAN")) {
            taxContext.setTaxServiceStrategy(new TaxCANServiceImpl());
        } else if (country.equalsIgnoreCase("JAM")) {
            taxContext.setTaxServiceStrategy(new TaxJAMServiceImpl());
        } else if (country.equalsIgnoreCase("USA")) {
            taxContext.setTaxServiceStrategy(new TaxUSAServiceImpl());
        }
        return taxContext;
    }

    /**
     * Returns an instance of InventoryController with the necessary dependencies.
     *
     * @return an InventoryController instance
     */
    public static InventoryController getInventoryController() {
        return new InventoryController(new InventoryFacade(
                new GroundShippingFactory(), new ExpressShippingFactory()
        ));
    }

    /**
     * Returns the OrderType based on the user input.
     *
     * @param input the user input
     * @return an OrderType instance
     */
    public static OrderType getOrderType(String input) {
        switch (input) {
            case "1":
                return OrderType.EXPRESS_ORDER;
            case "2":
                return OrderType.STANDARD_ORDER;
            default:
                throw new IllegalArgumentException("Invalid order type: " + input);
        }
    }


}