package hw9;

import java.util.HashSet;
import java.util.Set;

public class ProductList {
    public static Set<Product> productList = new HashSet<>();

    public static void addProduct(Product product) {
        if (productList.contains(product)) {
            throw new IllegalArgumentException("Продукт уже есть в списке!");
        }
        productList.add(product);
    }
}
