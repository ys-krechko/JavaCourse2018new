package homework.task30_7;

/*Создайте объект DAO.
Также необходимо создать классы Receiver и Expense, свойства которых соответствуют полям таблиц базы
данных расходов. Поле дата в классах можно хранить в виде строки.*/

public class DaoApplication {
    public static void main(String[] args) {
        MyDao myDao = MyDao.getMyDao();

        Receiver r1 = new Receiver();
        r1.setNum(1);
        r1.setName("Интернет-провайдер \"Соло\"");
        myDao.addReceiver(r1);
        Receiver r2 = new Receiver();
        r2.setNum(2);
        r2.setName("Гипермаркет \"Корона\"");
        myDao.addReceiver(r2);

        Expense e1 = new Expense();
        e1.setNum(1);
        e1.setPaydate("10.05.2011");
        e1.setReceiver(1);
        e1.setValue(94500);
        myDao.addExpense(e1);
        Expense e2 = new Expense();
        e2.setNum(2);
        e2.setPaydate("10.05.2010");
        e2.setReceiver(2);
        e2.setValue(35406);
        myDao.addExpense(e2);

        for (Receiver rec : myDao.getReceivers()) {
            System.out.println(rec.getNum() + "  " + rec.getName());
        }
        System.out.println("=======================================");
        for (Expense exp : myDao.getExpenses()) {
            System.out.println(exp.getNum() + "  " + exp.getPaydate() + "  " + exp.getReceiver() + "  " + exp.getValue());
        }
    }
}
