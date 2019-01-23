package homework.task18_1.ver02;

// генерирует заданое количество объектов типа покупатель
public class ConsumerGenerator implements Runnable {
    private Line line;
    private int consumerCount;

    public ConsumerGenerator(Line line, int consumerCount) {
        this.line = line;
        this.consumerCount = consumerCount;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < consumerCount) {
            Thread.currentThread().setName("Consumer generate ");
            count++;
            line.add(new Consumer());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
