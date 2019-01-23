package homework.task30_7;

import java.util.ArrayList;
import java.util.List;

public class MyDao implements Dao<Receiver, Expense> {

    private static MyDao myDao;

    private List<Receiver> receivers = new ArrayList<Receiver>();
    private List<Expense> expenses = new ArrayList<Expense>();

    private MyDao() {
    }

    public static synchronized MyDao getMyDao() {
        if (myDao == null) {
            myDao = new MyDao();
        }
        return myDao;
    }

    public int recSize() {
        return receivers.size();
    }

    public int expSize() {
        return expenses.size();
    }

    @Override
    public Receiver getReceiver(int num) {
        return receivers.get(num);
    }

    @Override
    public List<Receiver> getReceivers() {
        return receivers;
    }

    @Override
    public Expense getExpense(int num) {
        return expenses.get(num);
    }

    @Override
    public List<Expense> getExpenses() {
        return expenses;
    }

    @Override
    public boolean addReceiver(Receiver receiver) {
        return receivers.add(receiver);
    }

    @Override
    public boolean addExpense(Expense expense) {
        return expenses.add(expense);
    }

}
