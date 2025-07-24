package com.example.foodorder;
import java.util.*;

public class FoodOrderManagementSystem {
    static Map<String, Integer> menu = new HashMap<>();
    static Map<String, Integer> orders = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeMenu();

        while (true) {
            System.out.println("\n==== Food Ordering System ====");
            System.out.println("1. View Menu");
            System.out.println("2. Place Order");
            System.out.println("3. View Order Summary");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    System.out.print("Enter item name: ");
                    String item = scanner.nextLine();
                    if (!menu.containsKey(item)) {
                        System.out.println("Item not available.");
                        break;
                    }
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    orders.put(item, orders.getOrDefault(item, 0) + qty);
                    System.out.println("Added to order.");
                    break;
                case 3:
                    displayOrderSummary();
                    break;
                case 4:
                    System.out.println("Thank you for using Food Ordering System!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    static void initializeMenu() {
        menu.put("Burger", 100);
        menu.put("Pizza", 200);
        menu.put("Fries", 80);
        menu.put("Soda", 40);
    }

    static void displayMenu() {
        System.out.println("\n-- Menu --");
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ": ₹" + entry.getValue());
        }
    }

    static void displayOrderSummary() {
        if (orders.isEmpty()) {
            System.out.println("No items ordered yet.");
            return;
        }

        int total = 0;
        System.out.println("\n-- Order Summary --");
        for (Map.Entry<String, Integer> order : orders.entrySet()) {
            int price = menu.get(order.getKey()) * order.getValue();
            System.out.println(order.getKey() + " x " + order.getValue() + " = ₹" + price);
            total += price;
        }
        System.out.println("Total: ₹" + total);
    }
}