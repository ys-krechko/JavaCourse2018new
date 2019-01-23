package homework.task06_25;

import java.util.Random;

public abstract class Card extends BankName {
    String bankName;
    String type;
    int pin;

    Random r = new Random(); // реализация интерфейся
    Account<Integer> amountOfMoney = (bal) -> (bal + 5000 + r.nextInt(6000) - 1000);

    public Card(String bankName, String type, int pin) { // конструктор с тремя параметрами
        this.bankName = bankName;
        this.type = type;
        this.pin = pin;
    }

    public void PIN(int p) throws PinException { // метод проверки PIN с исключением

        if (this.pin != p) {
            throw new PinException("Вы ввели неверный PIN-код. Пожалуйста, попробуйте ещё раз.");
        }
        System.out.println("Вы ввели верный PIN-код");
    }

    public void cardBalance(int a) {
        System.out.println("Баланс счёта - " + amountOfMoney.balance(a));
    }

    @Override
    public void bankName() {
        System.out.println("Наименование банка - " + bankName);
    }

    @Override
    public void cardType() {
        System.out.println("Тип карты - " + type);
    }
}
