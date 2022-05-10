package ex03;

public class User {
    private Integer identifier;
    private String name;
    private Integer balance;
    private TransactionsList transactions;

    public User(String name, Integer balance){
        setName(name);
        setBalance(balance);
        identifier = UserIdsGenerator.getInstance().generatedId();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setBalance(Integer balance){
        if (balance < 0){
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setTransactionsList(TransactionsList transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString(){
        return "User id: " + identifier + ", name: " + this.getName() + ", balance: " + this.getBalance();
    }
}