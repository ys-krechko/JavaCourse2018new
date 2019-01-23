package homework.task30_7;

import java.util.List;

public interface Dao<Receiver, Expense> {
    Receiver getReceiver(int num);

    List<Receiver> getReceivers();

    Expense getExpense(int num);

    List<Expense> getExpenses();

    boolean addReceiver(Receiver receiver);

    boolean addExpense(Expense expense);

}
