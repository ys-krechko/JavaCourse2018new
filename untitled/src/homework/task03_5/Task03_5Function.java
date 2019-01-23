package homework.task03_5;

public class Task03_5Function {
    public String GetCase(int money) {
        String result = " ";
        int GetPrelastNumber = money % 100 / 10; // проверка является ли 1 вторым числом с конца
        if (GetPrelastNumber == 1) {
            result += "рублей";
        } else {
            switch (money % 10) { // определяет на какую цифру заканчивается число
                case 1:
                    result += "рублей";
                    break;
                case 2:
                case 3:
                case 4:
                    result += "рубля";
                    break;
                default:
                    result += "рублей";
                    break;
            }
        }
        return result;
    }
}
