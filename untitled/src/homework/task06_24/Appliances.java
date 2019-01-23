package homework.task06_24;

public abstract class Appliances implements AppliancesPower {
    boolean power;
    String name;


    public Appliances(boolean power, String name) {
        this.power = power;
        this.name = name;
    }

    public void name() {
        System.out.println(name);
    }

    @Override
    public void printPowerState() {
        if (power) {
            System.out.println("Питание включено");
        } else {
            System.out.println("Питание выключено");
        }
    }
}
