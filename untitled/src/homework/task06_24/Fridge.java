package homework.task06_24;

/*Создать иерархию классов, описывающих бытовую технику. Создать несколько объектов описанных классов,
часть из них включить в розетку. Иерархия должна иметь хотя бы три уровня.*/

public class Fridge extends Appliances implements AppliancesLifeTime{
    public Fridge(boolean power, String name) {
        super(power, name);
    }

    public static void main(String[] args){
        Fridge fridge = new Fridge(true, "Холодильник");
        fridge.name();
        System.out.println(lifeTime);
        fridge.printPowerState();
    }
}
