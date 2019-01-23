package homework;

/*
Найти в строке не только запятые, но и другие знаки препинания. Подсчитать общее их количество.
*/

public class Task06_18 {
    public static void main(String[] args) {
        String text = "! Мы,, поехали?; домой!-- все:- вчера' .";
        int lengthBefore = text.length();
        int lengthAfter = text.replaceAll("[,.!?;:'-]", "").length();
        System.out.println("Количество знаков препинания: " + (lengthBefore - lengthAfter));
    }
}
