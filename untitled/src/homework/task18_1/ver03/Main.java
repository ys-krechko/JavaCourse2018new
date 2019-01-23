package homework.task18_1.ver03;

/*Напишите программу, моделирующую кассы в магазине. Существует несколько касс, работающих одновреммено.
Каждый покупатель - отдельный поток. Общее количесвто покупателей может быть больше чем количество касс,
но одновременно не может обрабатываться боле покупателей чем имеется рабочих касс. У каждого покупателя
ксть набор товаров, которые должны быть выведены в процессе обслуживания.*/


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Line line = new Line();

        StoreCashierGenerator consumerGenerator = new StoreCashierGenerator(line, 2);

        Consumer consumer1 = new Consumer(line, "Покупатель №01");
        Consumer consumer2 = new Consumer(line, "Покупатель №02");
        Consumer consumer3 = new Consumer(line, "Покупатель №03");
        Consumer consumer4 = new Consumer(line, "Покупатель №04");

/*
        try {
            consumerGenerator.thrd.join();
            consumer1.thrd.join();
            consumer2.thrd.join();
            consumer3.thrd.join();
            consumer4.thrd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/


        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(consumerGenerator);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);
        service.execute(consumer4);

        service.shutdown();

    }
}
