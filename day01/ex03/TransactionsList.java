package ex03;

import java.util.UUID;

public interface TransactionsList {
    public void addTransaction(Transaction transaction);
    public Transaction removeTransactionById(String uuid);
    public Transaction[] toArray();
}