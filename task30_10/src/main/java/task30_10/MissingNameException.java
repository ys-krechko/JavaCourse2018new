package task30_10;

public class MissingNameException extends Exception {
    @Override
    public String getMessage() {
        return "Ошибка: не введено имя пользователя!";
    }

    @Override
    public String toString() {
        return "Ошибка: не введено имя пользователя!";
    }
}
