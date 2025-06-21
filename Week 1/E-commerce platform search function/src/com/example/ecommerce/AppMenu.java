package com.example.ecommerce;

import java.util.Scanner;

public class AppMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(103, "Coffee Maker", "Home Appliance"),
                new Product(104, "Smartphone", "Electronics"),
                new Product(105, "Backpack", "Accessories")
        };

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== E-Commerce Product Search ===");
            System.out.println("1. View All Products");
            System.out.println("2. Search by Product Name (Linear Search)");
            System.out.println("3. Search by Product ID");
            System.out.println("4. Search by Category");
            System.out.println("5. Search by Product Name (Binary Search)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    SearchEngine.displayAllProducts(products);
                    break;

                case 2:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    Product byName = SearchEngine.linearSearchByName(products, name);
                    System.out.println(byName != null ? byName : "Product not found.");
                    break;

                case 3:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    Product byId = SearchEngine.linearSearchById(products, id);
                    System.out.println(byId != null ? byId : "Product not found.");
                    break;

                case 4:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    Product[] byCategory = SearchEngine.linearSearchByCategory(products, category);
                    if (byCategory.length > 0) {
                        for (Product p : byCategory) System.out.println(p);
                    } else {
                        System.out.println("No products found in this category.");
                    }
                    break;

                case 5:
                    System.out.print("Enter product name: ");
                    String binaryName = scanner.nextLine();
                    SearchEngine.sortByName(products);  // Ensure sorted
                    Product binaryResult = SearchEngine.binarySearchByName(products, binaryName);
                    System.out.println(binaryResult != null ? binaryResult : "Product not found.");
                    break;

                case 0:
                    exit = true;
                    System.out.println("Exiting. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
