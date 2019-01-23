package homework;

/*Имеется текст. Следует создать для него частотный словарь.*/

import java.util.*;

public class Task11_29 {
    public static void main(String[] args) {
        String text = "Раз, два. Три три четыре? раз, раз! два ещё два; два'два Снежок-снежок: раз";
        List<String> words = new ArrayList<>(Arrays.asList(text.toLowerCase().replaceAll("[,.!?;:'-]", " ").split("\\s+")));
        System.out.print(words + " ");
        System.out.println();
        Map<String, Integer> voc = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            Integer freq = voc.get(words.get(i));
            voc.put(words.get(i), freq == null ? 1 : freq + 1);
        }
        System.out.println(voc);
    }
}
