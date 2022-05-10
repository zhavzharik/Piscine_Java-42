package ex03;

public class Program {

    public static void main(String[] args){
        User dog = new User("Rex", 5000);
        User cat = new User("Tom", 4000);
        User mouse = new User("Jerry", 3000);

        System.out.println(dog);
        System.out.println(cat);
        System.out.println(mouse);
        System.out.println();

        TransactionsList animals = new TransactionsLinkedList();
        dog.setTransactionsList(animals);
        cat.setTransactionsList(animals);
        mouse.setTransactionsList(animals);

        Transaction transfer1 = Transaction.createTransaction(cat, dog, -500);
        Transaction transfer2 = Transaction.createTransaction(dog, cat, 500);
        Transaction transfer3 = Transaction.createTransaction(mouse, dog, -500);
        Transaction transfer4 = Transaction.createTransaction(dog, mouse, 500);

        dog.setBalance(dog.getBalance() - 500);
        cat.setBalance(cat.getBalance() + 500);
        dog.setBalance(dog.getBalance() - 500);
        mouse.setBalance(mouse.getBalance() + 500);

        animals.addTransaction(transfer1);
        animals.addTransaction(transfer2);
        animals.addTransaction(transfer3);
        animals.addTransaction(transfer4);


        System.out.println("Rex has transferred $500 to Tom and $500 to Jerry");
        for (Transaction t : animals.toArray()) {
            System.out.println(t);
        }
        System.out.println();

        System.out.println(dog);
        System.out.println(cat);
        System.out.println(mouse);
        System.out.println();

        System.out.println("Delete third transaction");
        System.out.println(animals.removeTransactionById(transfer3.getIdentifier().toString()));
        System.out.println();

        System.out.println(" Transactions after removing");
        for (Transaction t : animals.toArray()) {
            System.out.println(t);
        }
        System.out.println();

        try {
            animals.removeTransactionById("");
        } catch (TransactionNotFoundException e) {
            System.out.println(e.getMessage());
        }

        UserIdsGenerator next = UserIdsGenerator.getInstance();
        System.out.println("Next Id: " + next.generatedId());
    }
}