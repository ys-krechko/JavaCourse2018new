package homework;

/*Имеется строка с текстом. Вывести текст, составленный из последних букв всех слов.*/

public class Task06_20 {
    public static void main(String[] args) {
        String text = " Один,  .два !три ; ещё-раз :.,четыре";
        String[] word = text.trim().replaceAll("[,.!?;:'-]", " ").split("\\s+");
        StringBuilder newText = new StringBuilder();
        for (String words : word) {
            newText.append(words.charAt(words.length() - 1));
        }
        System.out.print(newText);
    }
}
