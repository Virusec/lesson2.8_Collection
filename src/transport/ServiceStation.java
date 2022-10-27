package transport;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation {

    private final Queue<Transport> transports = new ArrayDeque<>();

    public Queue<Transport> getTransports() {
        return transports;
    }

    private void add(Transport transport) {
        transports.offer(transport);
    }

    public void addCar(Car car) {
        add(car);
    }

    public void addTruck(Truck truck) {
        add(truck);
    }

//    public void addTransports(Transport transport){
//        if (transport instanceof Bus) {
//            System.out.println("Для автобусов диагностика не требуется.");
//            return;
//        }
//
//        transports.add(transport);
//    }

    public void service() {
        while (!transports.isEmpty()) {
            Transport t = transports.poll();
            boolean result = t.passDiagnostics();
            if (!result) {
                t.fixTransport();
            }
        }
    }

}
