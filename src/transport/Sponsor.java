package transport;

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
}
