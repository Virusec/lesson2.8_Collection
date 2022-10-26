package hw9.dz3;
/*
Задание 2
Учитель каждый урок начинает с того, чтобы задавать каждому ученику пример из таблицы умножения, чтобы проверить знания.
Учитель хочет, чтобы все вопросы для учеников были разными. Всего в классе учатся 15 человек.

Напишите программу, которая будет выводить в консоль 15 уникальных и случайных задач из таблицы умножения в столбец,
то есть на одной строчке одно задание (от 2*2 до 9*9). Задачи должны быть уникальными, то есть примеры по типу
2*9 и 9*2 считаются повтором.

Критерии оценки
Создана коллекция, в которой хранится список задач.
В консоль задачи выводятся в столбец, на каждой новой строчке новая задача.
Исключены повторы заданий в списке.


Задание 3
В некоторых гос. структурах многих стран есть возможность вбить номер паспорта и получить информацию о том,
кому он принадлежит.

Напишите программу, которая содержит в себе упрощенный функционал этой системы.

+Создайте класс Passport, содержащий в себе поля:

+«Номер паспорта» (уникальное, неповторяющееся значение);
+«Фамилия»;
+«Имя»;
+«Отчество» (если имеется; может быть пустым);
+«Дата рождения».
+Выберите структуру данных, подходящую для хранения и получения (по номеру паспорта) объектов класса Passport.
Реализуйте 2 метода:
+ Принимает объект класса Passport и сохраняет его в коллекцию. В случае если в коллекции уже есть паспорт с данным
номером, необходимо обновить остальные поля класса (фамилию, имя и т. д.)
+ Принимает номер паспорта, ищет в коллекции объект с данным номером и возвращает весь объект. Если объект не найден,
возвращает null.
Критерии оценки
+Создан класс с указанными полями.
+Переопределены методы, если это необходимо.
+Все поля не могут быть null, кроме отчества.
+Выбрана верная коллекция.
+Метод сохранения корректно добавляет и обновляет данные.
+Метод получения объекта по номеру работает согласно условиям, не бросает исключения.

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    static Map<Integer, Passport> passportMap = new HashMap<>();
    public static void main(String[] args) {
        System.out.println("Задание 2");
        task();
        System.out.println("Задание 3");
        Passport ivanov = new Passport(644648,
                "Андрей",
                "Иванов",
                null,
                1987);
        Passport petrov = new Passport(858221,
                "Михаил",
                "Петров",
                "Иванович",
                1975);
        addPassport(ivanov);
        addPassport(petrov);
        getPassportByNumber(644648);
        getPassportByNumber(858221);
    }

    private static Passport getPassportByNumber(int number) {
        return passportMap.get(number);
    }

    private static void addPassport(Passport passport) {
        passportMap.put(passport.getNumberPassport(), passport);

    }


    static void task() {
        Set<Task> set = new HashSet<>(15);
        while (set.size() < 15) {
            set.add(new Task());
        }
        set.forEach(t -> System.out.println(t.getTask()));
    }

    public static class Task {
        private final String s;
        private final String rs;

        Task() {
            int a = (int) (Math.random() * 8) + 2;
            int b = (int) (Math.random() * 8) + 2;
            s = String.format("%d * %d", a, b);
            rs = String.format("%d * %d", b, a);
        }

        String getTask() {
            return s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return s.equals(task.s) || s.equals(task.rs);
        }

        @Override
        public int hashCode() {
            return s.hashCode() + rs.hashCode();
        }
    }
}


