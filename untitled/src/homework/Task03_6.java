package homework;

/*
Имеется три числа - день, месяц, год. Вывести в виде трех чисел дату следующего дня.
*/

public class Task03_6 {
    public static void main(String[] args) {
        int day = 30;
        int month = 4;
        int year = 2011;
        if ((day == 28) && (month == 2) && (year % 4 == 0 && year % 400 == 0 && year % 100 != 0)) { // проверка является ли февраль високосным
            day = 1;
            month++;
            System.out.println("Дата следующего дня: " + day + "." + month + "." + year);
        } else if ((day == 29) && (month == 2) && !(year % 4 == 0 && year % 400 == 0 && year % 100 != 0)) { // проверка не является ли февраль високосным
            day = 1;
            month++;
            System.out.println("Дата следующего дня: " + day + "." + month + "." + year);
        } else if ((day == 30) && (month == 4 || month == 6 || month == 9 || month == 11)) { // условие для месяцев с 30 днями в году
            day = 1;
            month++;
            System.out.println("Дата следующего дня: " + day + "." + month + "." + year);
        } else if ((day == 31) && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10)) { // условие для месяцев с 31 днём в году
            day = 1;
            month++;
            System.out.println("Дата следующего дня: " + day + "." + month + "." + year);
        } else if ((day == 31) && (month == 12)) { // условие для декабря
            day = 1;
            month = 1;
            year++;
            System.out.println("Дата следующего дня: " + day + "." + month + "." + year);
        } else {
            day++;
            System.out.println("Дата следующего дня: " + day + "." + month + "." + year);
        }
    }
}
