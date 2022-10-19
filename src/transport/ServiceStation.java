package transport;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation {

    private Queue<Transport> transports = new ArrayDeque<>();

    public Queue<Transport> getTransports() {
        return transports;
    }

    public void addTransports(Transport transport){
        if (transport instanceof Bus) {
            System.out.println("Для автобусов диагностика не требуется.");
            return;
        }

        transports.add(transport);
    }

    public void service() {
        while (!transports.isEmpty()) {
            Transport t = transports.poll();
            System.out.println(t.getBrand() +" "+t.getModel() + " техобслуживание пройдено!");
        }
    }
}
