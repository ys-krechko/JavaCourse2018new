package homework.task06_23;

public class Request {
    public boolean AskMoney(Money money, final int request) {  // процесс снятия заданной суммы денег.
        boolean answer;
        if (request % 10 != 0) { // В функции на вход - количество денег, на выход - булевское значение.
            System.out.println("Неверная сумма, пожалуйста, попробуйте ещё раз");
            answer = false;
        } else {
            if (money.sum() >= request) {
                int y1 = 0;
                int y2 = 0;
                int y3 = 0;
                int x1 = money.getDen100();
                int x2 = money.getDen50();
                int x3 = money.getDen20();
                int money2 = request;
                if (x1 > 0) {
                    while (x1 != 0 && (money2 - 100 > 0)) {
                        money2 -= 100;
                        x1--;
                        y1++;
                    }
                }
                if (money2 > 0 && x2 > 0) {
                    while (x2 != 0 && (money2 - 50 > 0)) {
                        money2 -= 50;
                        x2--;
                        y2++;
                    }
                }
                if (money2 > 0 && x3 > 0) {
                    while (x3 != 0 && (money2 - 20 > 0)) {
                        money2 -= 20;
                        x3--;
                        y3++;
                    }
                }
                System.out.println("Номинал в 100 руб. = " + y1 + " шт.\nНоминал в 50 руб. = " + y2 + " шт.\nНоминал в 20 руб. = " + y3 + " шт.");
                answer = true;
            } else {
                System.out.println("Недостаточно средств, пожалуйста, введите другую сумму");
                answer = false;
            }
        }
        return answer;
    }
}


