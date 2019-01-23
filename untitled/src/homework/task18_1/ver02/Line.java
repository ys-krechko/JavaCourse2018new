package homework.task18_1.ver02;

import java.util.ArrayList;
import java.util.List;

// хранилище объектов типа покупатель. С методами для добавления и изъятия объектов.
public class Line {
    private static final int maxConsumersInLine = 6;
    private static final int minConsumersInLine = 0;
    private List<Consumer> store;
    private int consumerCounter = 0;

    public Line() {
        store = new ArrayList<>();
    }

    public synchronized boolean add(Consumer consumer) {
        try {
            if (consumerCounter < maxConsumersInLine) {
                notifyAll();
                store.add(consumer);
                String info = ("Покупатель встал в очередь: " + store.size() + " " + Thread.currentThread().getName());
                System.out.println(info);
                consumerCounter++;
            } else {
                System.out.println(store.size() + "> Для покупателя нет места в очереди: " + Thread.currentThread().getName());
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Consumer get() {
        try {
            if (consumerCounter > minConsumersInLine) {
                notifyAll();
                for (Consumer consumer : store) {
                    consumerCounter--;
                    System.out.println(store.size() + "- Покупатель обслуживается на кассе: " + Thread.currentThread().getName());
                    store.remove(consumer);
                    return consumer;
                }
            }
            System.out.println("0 < Нет покупателей в очереди.");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}