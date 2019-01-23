package homework.task06_25;

/*Создать иерархию классов, описывающих банковские карточки. Иерархия должна иметь хотя бы три уровня.*/

public class Maestro extends Card {
    public Maestro(String bankName, String type, int pin) {
        super(bankName, type, pin);
    }

    public static void main(String[] args) throws PinException {
        Maestro maestro =new Maestro("Беларусбанк","Maestro", 6543);
        try {
            maestro.PIN(6543);
        } catch (PinException ex){
            System.out.println(ex.getMessage());
        }
        maestro.bankName();
        maestro.cardType();
        maestro.cardBalance(64);
    }
}
