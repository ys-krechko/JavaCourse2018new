package homework.task18_1.ver03;

import java.util.HashMap;
import java.util.Map;

// хранилище объектов типа покупатель. С методами для добавления и изъятия объектов.
public class Line {
    private static final int maxStoreCashierInLine = 6;
    private static final int minStoreCashierInLine = 0;
    StoreCashier x;
    private Map<Boolean, StoreCashier> store;
    private int storeCashierCounter = 0;

    public Line() {
        store = new HashMap<>();
    }

    public synchronized boolean put(StoreCashier storeCashier) {
        if (storeCashierCounter < maxStoreCashierInLine) {
            store.put(storeCashier.isFree(), storeCashier);
            String info = "Касса №" + store.size() + " готова к работе " + "(" + store.size() + " " + Thread.currentThread().getName() + ").";
            System.out.println(info);
            storeCashierCounter++;
        } else {
            System.out.println(store.size() + "> Кассы в магазине закончились.");
            return false;
        }
        return true;
    }

    public synchronized StoreCashier get() {
        for (Map.Entry<Boolean, StoreCashier> freeCashier : store.entrySet()) {
            if (freeCashier.getKey() == true) {
                x = freeCashier.getValue();
            }
        }
        return x;
    }

}









 /*public Line() {
        store = new ArrayList<>();
    }

    public synchronized boolean add(StoreCashier storeCashier) {
        try {
            if (storeCashierCounter < maxStoreCashierInLine) {
                notifyAll();
                store.add(storeCashier);
                String info = ("Касса открылась: " + store.size() + " " + Thread.currentThread().getName());
                System.out.println(info);
                storeCashierCounter++;
            } else {
                System.out.println(store.size() + "> Нет работающих касс: " + Thread.currentThread().getName());
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
            if (storeCashierCounter > minStoreCashierInLine) {
                notifyAll();
                for (Consumer consumer : store) {
                    storeCashierCounter--;
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
*/