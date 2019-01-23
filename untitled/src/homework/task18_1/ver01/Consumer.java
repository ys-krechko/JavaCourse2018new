package homework.task18_1.ver01;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Consumer implements Runnable {
    // необходимые переменные
    static StoreCashier storeCashier = new StoreCashier();
    Goods goods = new Goods();
    List<String> listOfPurchases;
    Thread thrd;
    String name;
    Random r = new Random();
    BigDecimal sum; // общая сумма покупок
    BigDecimal purse; // кошелёк

    //конструктор
    public Consumer(String name) {
        thrd = new Thread(this, name);
        thrd.start();
    }

    //начать выполнение нового потока
    @Override
    public void run() {
        goods.generate();
        System.out.println(thrd.getName() + " запуск.");
        commitPurchase();
        displayingList();
        storeCashier.sell(sum, purse);
        System.out.println(thrd.getName() + " завершение.");
    }

    // процесс совершения покупок
    private void commitPurchase() {
        int x = r.nextInt(10);
        listOfPurchases = new ArrayList<>(x); // для хранения наименований покупок
        sum = new BigDecimal(0);
        purse = new BigDecimal(r.nextInt(100)).setScale(2, RoundingMode.HALF_UP);
        for (int i = 0; i < x; i++) { // генерируется случаёное количество покупок
            // выбирается случайная покупка и его цена+происхлдит формирование общей суммы покупок
            int y = r.nextInt(10);
            listOfPurchases.add(goods.goodsName.get(y));
            sum = sum.add(goods.goodsPrice.get(y)).setScale(2, RoundingMode.HALF_UP);
        }
        purse = purse.add(sum); // добавление в кошелёк общей суммы покупок, чтобы покупателю всегда хватало денег расплатиться
        System.out.println("Сумма в кошельке " + thrd.getName() + ": " + purse + " руб.");
    }

    // выводит список покупок
    private void displayingList() {
        if (listOfPurchases.size() == 0) {
            System.out.println("Список покупок " + thrd.getName() + " пуст.");
            System.out.print("Ничего не понравилось.");
        } else {
            System.out.print("Список покупок " + thrd.getName() + ": ");
            for (String g : listOfPurchases) {
                System.out.print(g + " ");
            }
            System.out.println();
        }
    }
}
