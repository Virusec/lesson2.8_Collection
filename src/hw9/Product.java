package hw9;

/*
Домашнее задание 1.
Напишите простое приложение для формирования списка продуктов.

Требования к приложению:

Все товары в списке должны быть уникальными. При попытке добавить уже имеющийся продукт необходимо выбросить исключение.
Например, если в списке уже есть бананы, то второй раз добавить их нельзя.

+Каждому продукту помимо названия можно добавить две характеристики: цена и необходимое количество, которое указывается в килограммах.

+Если какой-то из параметров не заполнен, то программа должна выдавать ошибку и сообщение «Заполните карточку товара полностью».

В список продуктов можно добавить новый товар, отметить, что он уже куплен, или удалить его из списка.

Названия всех продуктов должны быть на русском языке.

Критерии проверки
+Создан класс Product.
+Создана коллекция, которая содержит в себе продукты.
+Коллекция удовлетворяет условиям задачи, где объекты не должны повторяться.
+Добавлены модификаторы доступа.
+Созданы геттеры и сеттеры для необходимых полей.
+Методы переопределены.
+Создано непроверяемое исключение, которое выбрасывает ошибку в случае, если в список добавляется уже имеющийся продукт.
+Создано непроверяемое исключение, которое выбрасывает ошибку в случае, если данные по объекту заполнены не полностью.
 */

import java.util.Objects;

public class Product {
    private final String name;
    private final Integer price;
    private final Double quantity;

    public Product(String name, Integer price, Double quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Заполните карточку товара полностью");
        } else {
            this.name = name;
        }

        if (price == null || price <= 0) {
            throw new IllegalArgumentException("Заполните карточку товара полностью");
        } else {
            this.price = price;
        }

        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Заполните карточку товара полностью");
        } else {
            this.quantity = quantity;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(quantity, product.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
}
