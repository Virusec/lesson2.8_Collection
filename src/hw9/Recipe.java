package hw9;
/*
Домашнее задание 2.
Задание 1
Вам необходимо усложнить задание со списком продуктов из прошлого урока. Создайте класс рецептов, который содержит поля:
+ Множество продуктов.
+ Суммарная стоимость всех продуктов у данного рецепта.
+ Название рецепта.
+Создайте множество, в котором будут храниться все рецепты. Добавьте в него несколько рецептов.

+Рецепты не могут иметь одинаковое название — при попытке добавить рецепт с уже занятыми названием необходимо выбросить
 исключение. Рецепты с разным названием, содержащие одинаковый список продуктов, считаются разными рецептами.

Критерии проверки
+Создан класс рецептов.
+Создана коллекция, которая содержит в себе рецепты.
+Класс рецептов должен быть неизменяемым (созданы только геттеры).
+Методы переопределены.
+Выбрасывается исключение при попытке добавить рецепт с названием, которое уже существует.
+Есть возможность добавить рецепты с разными названиями, но с одинаковым списком продуктов.

Задание 2.
+Создайте множество целых чисел. Заполните множество 20 случайными числами в диапазоне от 0 до 1000.

+Пройдитесь по всем элементам множества и удалите из него все нечетные значения. Выведите оставшиеся элементы в консоль.

Критерии проверки
+Создана коллекция, содержащая целые числа.
+Выбран нужный тип коллекции для решения задания.
+Множество заполнено случайными числами в указанном диапазоне.
+Удалены все нечетные числа.
+Все оставшиеся значения выводятся в консоль.
 */

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Recipe {
    private final String name;
    private int amountCostRecipe;
    private final Set<Product> products;

    public Recipe(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Введите название рецепта!");
        } else {
            this.name = name;
        }
        this.amountCostRecipe = 0;
        this.products = new HashSet<>();
    }

    public void addProductRecipe(Product product) {
        if (products.contains(product)) {
            throw new IllegalArgumentException("Продукт уже в списке!");
        }
        products.add(product);
        amountCostRecipe += product.getPrice();
    }

    public String getName() {
        return name;
    }

    public int getAmountCostRecipe() {
        return amountCostRecipe;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", amountCostRecipe=" + amountCostRecipe +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(name, recipe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
