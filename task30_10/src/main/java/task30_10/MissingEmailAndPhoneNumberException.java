package task30_10;

public class MissingEmailAndPhoneNumberException extends Exception {
    @Override
    public String getMessage() {
        return "Ошибка: отсутствуют номер телефона и адрес электронной почты!";
    }

    @Override
    public String toString() {
        return "Ошибка: отсутствуют номер телефона и адрес электронной почты!";
    }
}
