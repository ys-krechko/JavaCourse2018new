package homework.task18_1.ver02;

/*Напишите программу, моделирующую кассы в магазине. Существует несколько касс, работающих одновреммено.
Каждый покупатель - отдельный поток. Общее количесвто покупателей может быть больше чем количество касс,
но одновременно не может обрабатываться боле покупателей чем имеется рабочих касс. У каждого покупателя
ксть набор товаров, которые должны быть выведены в процессе обслуживания.*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Line line = new Line();

        ConsumerGenerator consumerGenerator = new ConsumerGenerator(line, 6);

        StoreCashier storeCashier1 = new StoreCashier(line, "№1");
        StoreCashier storeCashier2 = new StoreCashier(line, "№2");
        StoreCashier storeCashier3 = new StoreCashier(line, "№3");

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(consumerGenerator);
        service.execute(storeCashier1);
        service.execute(storeCashier2);
        service.execute(storeCashier3);

        service.shutdown();
    }
}
