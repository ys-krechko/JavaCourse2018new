package homework.task18_1.ver02;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Consumer {
    // необходимые переменные
    GoodsList goods = new GoodsList();
    List<String> listOfPurchases;

    Random r = new Random();
    BigDecimal sum; // общая сумма покупок
    BigDecimal purse; // кошелёк

    synchronized void process() {
        goods.generate();
        commitPurchase();
        displayingList();
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
        System.out.println("Сумма в кошельке " + purse + " руб.");
    }

    // выводит список покупок
    private void displayingList() {
        if (listOfPurchases.size() == 0) {
            System.out.println("Список покупок пуст.");
            System.out.print("Ничего не понравилось.");
        } else {
            System.out.print("Список покупок: " + " ");
            for (String g : listOfPurchases) {
                System.out.print(g + " ");
            }
        }
    }
}
