package transport;

public class Engineer<B extends Transport> {
    private final String name;

    private final String surname;

    private final String company;

    public Engineer(String name, String surname,String company) {
        if (name == null || name.isBlank()) {
            this.name = "Введите имя!";
        } else {
            this.name = name;
        }

        if (surname == null || surname.isBlank()) {
            this.surname = "Введите фамилию!";
        } else {
            this.surname = name;
        }

        if (company == null || company.isBlank()) {
            this.company = "Введите название компании!";
        } else {
            this.company = company;
        }
    }

    public void performMaintenanceTransport(B b) {
        b.performMaintenanceTransport();
    }

    public void fixTransport(B b) {
        b.fixTransport();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}