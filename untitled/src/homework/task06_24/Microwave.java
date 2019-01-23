package homework.task06_24;

/*Создать иерархию классов, описывающих бытовую технику. Создать несколько объектов описанных классов,
часть из них включить в розетку. Иерархия должна иметь хотя бы три уровня.*/

public class Microwave extends Appliances implements AppliancesLifeTime{
    public Microwave(boolean power, String name) {
        super(power, name);
    }

    public static void main (String[] args){
        Microwave microwave = new Microwave(false, "Микроволновка");
        microwave.name();
        System.out.println(lifeTime);
        microwave.printPowerState();
    }
}
