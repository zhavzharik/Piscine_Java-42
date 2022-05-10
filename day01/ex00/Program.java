package ex00;

public class Program {

    public static void main(String[] args){
        User dog = new User("Rex", 5000);
        User cat = new User("Tom", 4000);

        dog.setIdentifier(1);
        cat.setIdentifier(2);

        System.out.println(dog);
        System.out.println(cat);
        System.out.println();

        System.out.println("Rex has transferred $500 to Tom.");
        Transaction transfer1 = Transaction.createTransaction(cat, dog, -500);
        Transaction transfer2 = Transaction.createTransaction(dog, cat, 500);

        System.out.println(transfer1);
        System.out.println(transfer2);
        System.out.println();

        dog.setBalance(dog.getBalance() - 500);
        cat.setBalance(cat.getBalance() + 500);

        System.out.println(dog);
        System.out.println(cat);
        System.out.println();

        System.out.println("Rex is trying to transfer $5000 to Tom.");
        transfer2 = Transaction.createTransaction(cat, dog, -5000);
        transfer1 = Transaction.createTransaction(dog, cat, 5000);

        System.out.println(transfer1);
        System.out.println(transfer2);
    }
}