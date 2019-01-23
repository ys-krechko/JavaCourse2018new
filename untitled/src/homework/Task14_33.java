package homework;

/*Вывести список файлов и каталогов выбранного каталога на диске.
Файлы и каталоги должны быть распечатаны отдельно.*/

import java.io.File;

public class Task14_33 {
    public static void main(String[] args) {
        File f = new File("D:\\");

        File[] files = f.listFiles(File::isFile); //список файлов
        for (File fs : files) {
            System.out.println(fs);
        }
        System.out.println();

        File[] directories = f.listFiles(File::isDirectory); //список каталогов
        for (File dir : directories) {
            System.out.println(dir);
        }
    }
}
