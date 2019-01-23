package homework.task06_23;

public class Money {
    private static int den20; // кол-во купюр номиналом 20
    private static int den50; // кол-во купюр номиналом 50
    private static int den100; // кол-во купюр номиналом 100

    public int getDen20() {
        return den20;
    }

    public void setDen20(int den20) {
        this.den20 = den20;
    }

    public int getDen50() {
        return den50;
    }

    public void setDen50(int den50) {
        this.den50 = den50;
    }

    public int getDen100() {
        return den100;
    }

    public void setDen100(int den100) {
        this.den100 = den100;
    }

    public Money(int den20, int den50, int den100) {
        this.den20 = den20;
        this.den50 = den50;
        this.den100 = den100;
    }

    public void AddMoney(int add20, int add50, int add100) {  // добавляем купюры в банкомат
        den20 += add20;
        den50 += add50;
        den100 += add100;
    }

    public int sum() {
        return 20 * den20 + 50 * den50 + 100 * den100;
    }
}
