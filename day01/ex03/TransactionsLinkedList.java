package ex03;

class TransactionNotFoundException extends RuntimeException {}

public class TransactionsLinkedList implements TransactionsList {
    private TransactionNode begin;
    private TransactionNode end;
    private int number;

    public TransactionsLinkedList() {
        begin = new TransactionNode(null);
        end = new TransactionNode(null);

        begin.next = end;
        end.prev = begin;
        number = 0;
    }

    public void addTransaction(Transaction transaction) {
        (new TransactionNode(transaction)).lstNew(end);
        number += 1;
    }

    public Transaction removeTransactionById(String uuid) {
        TransactionNode target = getFirst();
        while (target != end) {
            if (uuid.equals(target.getData().getIdentifier().toString())) {
                target.remove();
                number -= 1;
                return target.getData();
            }
            target = target.next;
        }
        throw new TransactionNotFoundException();
    }

    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[number];

        TransactionNode current = getFirst();
        for (int i = 0; i < number; i++, current = current.next) {
            transactions[i] = current.getData();
        }
        return transactions;
    }

    private TransactionNode getFirst() {
        return begin.next;
    }

    private class TransactionNode {
        private TransactionNode prev;
        private Transaction data;
        private TransactionNode next;

        public TransactionNode(Transaction data) {
            this.data = data;
        }

        public void setData(Transaction data) {
            this.data = data;
        }

        public Transaction getData() {
            return data;
        }

        public TransactionNode getNext() {
            return next;
        }

        public TransactionNode getPrev() {
            return prev;
        }

        public void lstNew(TransactionNode end) {
            prev = end.prev;
            prev.next = this;
            end.prev = this;
            next = end;
        }

        public void remove() {
            next.prev = prev;
            prev.next = next;
            next = null;
            prev = null;
        }
    }
}