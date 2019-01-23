package homework;

/*Имеется целое число, следует вывести его в бухгалтерском формате.
Т.е. начиная справа каждые три позиции отделяются пробелом.
Например число 20023143 должно быть выведено как 20 023 143.*/

/*Вопрос: если в добавляемом элементе первый символ 0 (прим.: 023), то он "съедается" (23).
Как сделать чтобы он не пропадал?*/

import java.util.ArrayList;
import java.util.List;

public class Task03_12 {
    public static void main(String[] args) {
        int x = 20523143;
        List<Integer> number = new ArrayList<Integer>();
        while (x != 0) {
            number.add(0, x % 1000); // если вводимый элемент начинается с 0 (прим.: 023), то 0 пропадает (23)
            x /= 1000;
        }
        for (Integer numbers : number) {
            System.out.print(numbers + " ");
        }
    }
}
