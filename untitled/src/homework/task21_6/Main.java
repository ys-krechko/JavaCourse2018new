package homework.task21_6;

/*Создать простейший логгер, выводящий сообщения об ошибках в текстовый файл. Объект логгера должен
быть создан с помощью ШП Singleton. У объекта должен быть обязательным один метод, получающий на
вход текст об ошибке и записывающий его в файл вместе с информацией о дате и времени.*/

public class Main {
    public static void main(String[] args) {
        ProgramLogger.getLogger().addLogInfoFile("Первая ошибка");
        ProgramLogger.getLogger().addLogInfoFile("Вторая ошибка");
        ProgramLogger.getLogger().addLogInfoFile("Третья ошибка");
        ProgramLogger.getLogger().readLogFile();
    }
}
