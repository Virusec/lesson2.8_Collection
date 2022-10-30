package transport;

import java.util.Objects;

public class Sponsor {
    private final String name;
    private final int amountOfSupport;

    public Sponsor(String name, int amountOfSupport) {
        if (name == null || name.isBlank()) {
            this.name = "Введите имя или название компании!";
        } else {
            this.name = name;
        }

        this.amountOfSupport = amountOfSupport;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfSupport() {
        return amountOfSupport;
    }

    public void sponsorTheRace() {
        System.out.println("Спонсор " + getName() + " спонсирует заезд на " + getAmountOfSupport() + " !");
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "name='" + name + '\'' +
                ", amountOfSupport=" + amountOfSupport +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return Objects.equals(name, sponsor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
