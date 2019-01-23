package homework.task06_23;

/*
Задача №23.
Создать класс и объекты описывающие Банкомат.
Набор купюр находящихся в банкомате должен задаваться тремя свойствами: количеством купюр номиналом 20 50 100.
Сделать методы для добавления денег в банкомат.
Сделать функцию снимающую деньги. На вход передается сумма денег. На выход – булевское значение (операция удалась или нет).
При снятии денег функция должна рапечатывать каким количеством купюр какого номинала выдается сумма.
Создать конструктор с тремя параметрами – количеством купюр.
 */
public class Main_Process {
    public static void main(String[] args) {
        Money money = new Money(5, 10, 15);
        AddMoney(money);
        Request r = new Request();
        System.out.println("Операция удалась? " + r.AskMoney(money, 610));
    }

    private static void AddMoney(Money money) {
        money.AddMoney(5, 5, 5);
        System.out.println("Купюр номиналом 20: " + money.getDen20() + ". Купюр номиналом 50: " + money.getDen50() + ". Купюр номиналом 100: " + money.getDen100());
        System.out.println("Доступная сумма: " + money.sum());
    }
}
