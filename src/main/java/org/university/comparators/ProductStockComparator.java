package org.university.comparators;

import org.university.Product;

import java.util.Comparator;

public class ProductStockComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return Integer.compare(p2.getStock(), p1.getStock());
    }
}
