package transport;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Bus aeroTown = new Bus("Hyundai", "Aero Town", 3.1, TypeOfCapacity.ESPECIALLY_BIG);
        Bus aurora = new Bus("ПАЗ", "Аврора", 2.8, TypeOfCapacity.MIDDLE);
        Bus crafter = new Bus("Volkswagen", "Crafter", 3.2);
        Bus sprinter = new Bus("Mercedes-Benz", "Sprinter", 3.5, TypeOfCapacity.ESPECIALLY_SMALL);

        Car lada = new Car("Lada", "Kalina", 1.6, TypeOfBody.SEDAN);
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 5, TypeOfBody.STATION_WAGON);
        Car bmw = new Car("BMW", "Z8", 2.5, TypeOfBody.COUPE);
        Car hyundai = new Car("Hyundai", "Avante", 1.8, TypeOfBody.SEDAN);

        Truck fighter = new Truck("Mitsubishi", "Fighter", 8.2, TypeOfWeight.N2);
        Truck bichok = new Truck("ЗИЛ", "5301 Бычок", 4.0, TypeOfWeight.N3);
        Truck vario = new Truck("Mercedes-Benz", "Vario", 4.2, TypeOfWeight.N1);
        Truck tgl = new Truck("MAN", "TGL", 6.7, TypeOfWeight.N1);

        aeroTown.printInfo();
        tgl.doBestLapTime();

        Driver<Bus> kostya = new Driver<>("Kostya Minin", "D", 6, crafter);
        Driver<Car> andrei = new Driver<>("Andrei Ivanov", "B", 4, audi);
        Driver<Car> maxim = new Driver<>("Maxim Zonin", "B", 4, lada);
        Driver<Truck> mihail = new Driver<>("Mihail Kotov", "C", 8, vario);

        kostya.startMoving(aurora);
        andrei.startMoving(bmw);
        mihail.refuel(fighter);

        printInfoRace(andrei);

        lada.setTypeOfBody(TypeOfBody.HATCHBACK);
        crafter.determineType();
        sprinter.determineType();
        hyundai.determineType();
        bichok.determineType();

        service(aeroTown, aurora, crafter, sprinter,
                lada, audi, bmw, hyundai,
                fighter, bichok, vario, tgl);
        printSeparator();

        List<Competing> transportList = new ArrayList<>(12);
        transportList.add(lada);
        transportList.add(audi);
        transportList.add(bmw);
        transportList.add(hyundai);
        transportList.add(aeroTown);
        transportList.add(aurora);
        transportList.add(crafter);
        transportList.add(sprinter);
        transportList.add(fighter);
        transportList.add(bichok);
        transportList.add(vario);
        transportList.add(tgl);

        Sponsor simaLand = new Sponsor("Sima Land", 200_000);
        Sponsor bp = new Sponsor("British Petroleum", 300_000);
        Sponsor mVideo = new Sponsor("M video", 400_000);

        Engineer bob = new Engineer<>("Bob", "Marley", "American technic");
        Engineer mark = new Engineer<>("Mark", "Worst", "American technic");
        Engineer tim = new Engineer<>("Tim", "Lloyd", "Technic system");

        List<Sponsor> sponsorList = new ArrayList<>();
        sponsorList.add(simaLand);
        sponsorList.add(bp);
        sponsorList.add(mVideo);

        List<Driver> driverList = new ArrayList<>();
        driverList.add(kostya);
        driverList.add(andrei);
        driverList.add(maxim);
        driverList.add(mihail);

        List<Engineer> engineerList = new ArrayList<>();
        engineerList.add(bob);
        engineerList.add(mark);
        engineerList.add(tim);

        lada.addDriver(maxim);
        lada.addSponsor(mVideo);
        lada.addSponsor(bp);
        lada.addEngineer(mark);
        lada.addEngineer(bob);
        lada.addEngineer(tim);

        lada.printAllInfo();

        printSeparator();

        ServiceStation s = new ServiceStation();
        s.addTransports(audi);
        s.addTransports(aeroTown);
        s.addTransports(lada);
        s.service();

        printSeparator();

        Queue<String> queue1 = new ArrayDeque<>(5);
        Queue<String> queue2 = new ArrayDeque<>(5);
        for (int i = 0; i < Math.floor(Math.random() * 5); i++) {
            queue1.offer("Larisa" + i);
        }
        for (int i = 0; i < Math.floor(Math.random() * 5); i++) {
            queue2.offer("Misha" + i);
        }

        System.out.println(queue1);
        System.out.println(queue2);

        addConsumer("Vasya", queue1, queue2);

        removeFromQueue("Petya", queue1, queue2);

        printSeparator();
        example();
    }

    static void example() {
        List<List<String>> biDemArrList = new ArrayList<>();
        boolean change = true;
        for (int i = 0; i < 8; i++) {
            biDemArrList.add(i, new ArrayList<>());
            for (int j = 0; j < 8; j++) {
                int relation = 0;
                if (change) relation = 1;
                if (j % 2 == relation) {
                    biDemArrList.get(i).add(j, "●");
                } else {
                    biDemArrList.get(i).add(j, "◯");
                }
            }
            change = !change;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(biDemArrList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void removeFromQueue(String name, Queue<String> queue1, Queue<String> queue2) {
        if (Math.random() > 0.5) {
            queue1.poll();
        } else {
            queue2.poll();
        }
    }

    public static void addConsumer(String name, Queue<String> queue1, Queue<String> queue2) {
        if (queue1.size() == queue2.size() && queue1.size() == 5) {
            System.out.println("Галя!");
        }
        if (queue1.size() < queue2.size()) {
            queue1.add(name);
        }
        if (queue2.size() < queue1.size()) {
            queue2.add(name);
        }
        System.out.println(queue1.size());
        System.out.println(queue2.size());
    }

    private static void service(Transport... transports) {
        for (Transport transport : transports) {
            service(transport);
        }
    }

    private static void service(Transport transport) {
        try {
            if (!transport.passDiagnostics()) {
                throw new RuntimeException("Транспорт " + transport.getBrand() + " " + transport.getModel() + " не прошел диагностику.");
            } else {
                System.out.println("Транспорт " + transport.getBrand() + " " + transport.getModel() + " успешно прошел диагностику!");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printInfoRace(Driver<? extends Transport> drivers) {
        System.out.println("Водитель " + drivers.getName()
                + " управляет автомобилем " + drivers.getTransport().getBrand() + drivers.getTransport().getModel()
                + " и будет участвовать в заезде.");
    }

    private static void printSeparator() {
        System.out.println("****************************************");
    }
}