package ex00;

public class User {
    private Integer identifier;
    private String name;
    private Integer balance;

    public User(String name, Integer balance){
        setName(name);
        setBalance(balance);
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

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
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

    @Override
    public String toString(){
        return "User id: " + this.getIdentifier() + ", name: " + this.getName() + ", balance: " + this.getBalance();
    }
}