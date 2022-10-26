package hw9.dz3;

import java.util.Objects;

public class Passport {
    private final int numberPassport;
    private String name;
    private String surname;
    private String patronymic;
    private int dateOfBirth;

    public Passport(int numberPassport, String name, String surname, String patronymic, int dateOfBirth) {
        this.numberPassport = numberPassport;
        setName(name);
        setSurname(surname);
        setPatronymic(patronymic);
        setDateOfBirth(dateOfBirth);
    }

    public int getNumberPassport() {
        return numberPassport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Введите имя!");
        } else {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isBlank()) {
            throw new IllegalArgumentException("Введите фамилию!");
        } else {
            this.surname = surname;
        }
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return numberPassport == passport.numberPassport && dateOfBirth == passport.dateOfBirth && Objects.equals(name, passport.name) && Objects.equals(surname, passport.surname) && Objects.equals(patronymic, passport.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberPassport, name, surname, patronymic, dateOfBirth);
    }
}
