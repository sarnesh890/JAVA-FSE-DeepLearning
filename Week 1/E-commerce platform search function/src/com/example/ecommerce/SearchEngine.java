package com.example.ecommerce;

import java.util.Arrays;
import java.util.Comparator;

public class SearchEngine {

    // Linear Search by Product Name
    public static Product linearSearchByName(Product[] products, String name) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Linear Search by Product ID
    public static Product linearSearchById(Product[] products, int id) {
        for (Product product : products) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    // Linear Search by Category (returns multiple products)
    public static Product[] linearSearchByCategory(Product[] products, String category) {
        return Arrays.stream(products)
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .toArray(Product[]::new);
    }

    // Binary Search by Product Name (array must be sorted by name)
    public static Product binarySearchByName(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String midName = products[mid].getProductName();

            int comparison = name.compareToIgnoreCase(midName);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    }

    // Sort by product name (for binary search)
    public static void sortByName(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));
    }
    public static void displayAllProducts(Product[] products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
