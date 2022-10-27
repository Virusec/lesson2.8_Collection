package hw9;

import java.util.HashSet;
import java.util.Set;

public class ProductList {
    private static Set<Product> productList = new HashSet<>();

    public static void addProduct(Product product) {
        if (productList.contains(product)) {
            throw new IllegalArgumentException("Продукт уже есть в списке!");
        }
        productList.add(product);
    }

    public static Set<Product> getProductList() {
        return productList;
    }
}
