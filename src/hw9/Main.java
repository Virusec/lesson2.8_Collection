package hw9;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Домашнее задание 1.");
        Product cucumber = new Product("Огурцы", 150, 1.5);
        Product banana = new Product("Бананы", 90, 2.0);
        Product tomato = new Product("Помидоры", 120, 1.5);
        Product potato = new Product("Картошка", 60, 3.5);
        Product onion = new Product("Лук", 45, 2.5);
        List<Product> products = List.of(cucumber, banana, tomato, potato, onion);

        for (Product product : products) {
            ProductList.addProduct(product);
        }
        System.out.println(ProductList.productList);
        printSeparator();
        System.out.println("Домашнее задание 2.Задание 1");
        Recipe friedPotato = new Recipe("Жареная картошка");
        friedPotato.addProductRecipe(onion);
        friedPotato.addProductRecipe(potato);

        Recipe salad = new Recipe("Салат");
        salad.addProductRecipe(cucumber);
        salad.addProductRecipe(tomato);
        salad.addProductRecipe(onion);

        Recipe salad1 = new Recipe("Салат");
        salad1.addProductRecipe(cucumber);
        salad1.addProductRecipe(tomato);
        salad1.addProductRecipe(onion);

        RecipeBook.addRecipe(salad);
        RecipeBook.addRecipe(friedPotato);
        RecipeBook.addRecipe(salad1);
        System.out.println(RecipeBook.recipes);
        printSeparator();
        System.out.println("Домашнее задание 2.Задание 2.");
        Set<Integer> nums = new HashSet<>(20);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {

            nums.add(random.nextInt(1001));
        }
        System.out.println(nums);
        nums.removeIf(num -> num % 2 != 0);
        System.out.println(nums);
//        List<Recipe> recipeList = List.of(salad, friedPotato);
//        printSeparator();
//        System.out.println(recipeList);

//        Recipe <Set<Product>>
    }

    static void printSeparator() {
        System.out.println("*********************************************");
    }

}
