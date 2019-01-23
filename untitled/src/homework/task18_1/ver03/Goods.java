package homework.task18_1.ver03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Goods {
    List<String> goodsName = new ArrayList<>(); // список доступных товаров;
    List<BigDecimal> goodsPrice = new ArrayList<>(); // цены доступных товаров;

    public void generate() {
        goodsName.add("Мясо");
        goodsName.add("Молоко");
        goodsName.add("Колбаса");
        goodsName.add("Хлеб");
        goodsName.add("Сыр");
        goodsName.add("Масло");
        goodsName.add("Кефир");
        goodsName.add("Сметана");
        goodsName.add("Творог");
        goodsName.add("Картошка");

        goodsPrice.add(new BigDecimal(2.35));
        goodsPrice.add(new BigDecimal(1.02));
        goodsPrice.add(new BigDecimal(1.90));
        goodsPrice.add(new BigDecimal(0.99));
        goodsPrice.add(new BigDecimal(1.20));
        goodsPrice.add(new BigDecimal(1.00));
        goodsPrice.add(new BigDecimal(0.98));
        goodsPrice.add(new BigDecimal(0.57));
        goodsPrice.add(new BigDecimal(0.32));
        goodsPrice.add(new BigDecimal(1.05));
    }
}
