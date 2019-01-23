package homework.task10_1;

/*Создать аннотацию, которая будучи применена к методу, выведет вермя его выполнения.*/

import java.lang.reflect.Method;

public class HelloWorld {

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();

        {
            long begin = 0;
            long end = 0;
            for (Method m : helloWorld.getClass().getMethods()) {
                if (m.isAnnotationPresent(TimeCount.class)) {
                    try {
                        begin = System.nanoTime();
                        m.invoke(helloWorld);
                        end = System.nanoTime();
                        System.out.println("Время выполнения метода - " + (end - begin) + " наносекунд.");
                    } catch (Exception ex) {
                        System.out.println(ex.getCause());
                    }
                }
            }
        }
    }


    @TimeCount
    public void print() {
        System.out.println("Hello world");
    }

    @TimeCount
    public void printMore(){
        System.out.println("Done");
    }
}
