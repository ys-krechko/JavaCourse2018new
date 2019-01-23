package homework.task06_25;

/*Создать иерархию классов, описывающих банковские карточки. Иерархия должна иметь хотя бы три уровня.*/

public class Visa extends Card {

    public Visa(String bankName, String type, int pin) {
        super(bankName, type, pin);
    }

    public static void main(String[] args) throws PinException {
        Visa visa = new Visa("Белинвестбанк", "Visa", 5246);
        try {
            visa.PIN(1223);
        } catch (PinException e) {
            System.out.println(e.getMessage());
        }
        visa.bankName();
        visa.cardType();
        visa.cardBalance(504);
    }
}
