package transport;

import java.util.ArrayList;
import java.util.List;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final double engineVolume;

    private final List<Driver<?>> drivers = new ArrayList<>();
    private final List<Engineer<?>> engineers = new ArrayList<>();
    private final List<Sponsor> sponsors = new ArrayList<>();


    public Transport(String brand, String model, double engineVolume) {

        if (isNull(brand)) {
            this.brand = "default";
        } else {
            this.brand = brand;
        }

        if (isNull(model)) {
            this.model = "default";
        } else {
            this.model = model;
        }

        if (engineVolume < 0) {
            this.engineVolume = 0;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public void addDriver(Driver<?> driver) {
        drivers.add(driver);
    }
    public void addEngineer(Engineer<?> engineer) {
        engineers.add(engineer);
    }
    public void addSponsor(Sponsor sponsor) {
        sponsors.add(sponsor);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public List<Driver<?>> getDrivers() {
        return drivers;
    }

    public List<Engineer<?>> getEngineers() {
        return engineers;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public abstract void startMoving();

    public abstract void finishMoving();

    public void printInfo() {
        System.out.println(getClass()
                + " (Марка - " + getBrand()
                + ", модель - " + getModel()
                + ", объем двигателя: " + getEngineVolume()
                + ".)");
    }

    public abstract boolean passDiagnostics();

    @Override
    public String toString() {
        return getBrand() + " " + getModel();
    }

    public boolean isNull(String value) {
        return value == null || value.isBlank();
    }

    public abstract void performMaintenanceTransport();

    public abstract void fixTransport();

    public void printAllInfo() {
        System.out.print("Drivers name is: " + getDrivers() + " Sponsors are: ");
        for (Sponsor sponsor : sponsors) {
            System.out.print(sponsor.getName() + " ");
        }
        System.out.print("Engineers are: ");
        for (Engineer<?> engineer : engineers) {
            System.out.print(engineer.getName() + " ");
        }
    }
}
