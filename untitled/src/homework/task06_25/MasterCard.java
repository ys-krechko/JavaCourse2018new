package homework.task06_25;

public class MasterCard extends Card{
    public MasterCard(String bankName, String type, int pin) {
        super(bankName, type, pin);
    }

    public static void main (String[] args) throws PinException {
        MasterCard masterCard = new MasterCard("Приорбанк", "MasterCard", 0354);
        try {
            masterCard.PIN(0315);
        } catch (PinException e) {
            System.out.println(e.getMessage());
        }
        masterCard.bankName();
        masterCard.cardType();
        masterCard.cardBalance(35400);
    }
}
