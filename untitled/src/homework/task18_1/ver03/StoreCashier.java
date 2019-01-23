package homework.task18_1.ver03;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StoreCashier {
    private boolean free = true;
    private String name;
    Thread thrd;

    public StoreCashier(String name) {
        this.name = name;
    }

    public boolean isFree() {
        return free;
    }

    public synchronized void sell(BigDecimal sum, BigDecimal purse) {
        free = false;
        int percent = 5;
        BigDecimal result = new BigDecimal(0);

        System.out.println(name);
        if (sum.compareTo(new BigDecimal(4.00)) < 0) {
            System.out.println("Скидка - 0%.");
            System.out.println("Общая сумма чека: " + sum + " руб.");
            System.out.println("Оплачено: " + purse + " руб.");
            System.out.println("Сдача: " + (purse.subtract(sum)) + " руб.");
        } else {
            int discount = sum.intValue();
            discount *= (percent / 100);
            result = result.add(sum).subtract(new BigDecimal(discount)).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Скидка - " + percent + " %.");
            System.out.println("Общая сумма чека: " + result + " руб.");
            System.out.println("Оплачено: " + purse + " руб.");
            System.out.println("Сдача: " + (purse.subtract(result)) + " руб.");
        }
        free = true;
    }
}
