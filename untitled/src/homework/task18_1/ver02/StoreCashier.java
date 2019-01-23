package homework.task18_1.ver02;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StoreCashier implements Runnable {
    private Line line;
    private String name;

    public StoreCashier(Line line, String name) {
        this.line = line;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            Thread.currentThread().setName("StoreCashier " + name);
            Consumer consumer = line.get();
            consumer.process();
            discount(consumer);
        }
    }

    public void discount(Consumer consumer) {
        int percent = 5;
        BigDecimal result = new BigDecimal(0);
        if (consumer.sum.compareTo(new BigDecimal(4.00)) < 0) {
            System.out.println("\nСкидка - 0%." + "\nОбщая сумма чека: " + consumer.sum + " руб.");
            System.out.println("Оплачено: " + consumer.purse + " руб.\nСдача: " + (consumer.purse.subtract(consumer.sum)) + " руб.");
        } else {
            int discount = consumer.sum.intValue();
            discount *= (percent / 100);
            result = result.add(consumer.sum).subtract(new BigDecimal(discount)).setScale(2, RoundingMode.HALF_UP);
            System.out.println("\nСкидка - " + percent + " %." + "\nОбщая сумма чека: " + result + " руб.");
            System.out.println("Оплачено: " + consumer.purse + " руб.\nСдача: " + (consumer.purse.subtract(result)) + " руб.");
        }
    }
}
