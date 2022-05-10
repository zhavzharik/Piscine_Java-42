package ex03;

import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User recipient;
    private User sender;
    private Integer amount;

    private enum Category{
        DEBIT("INCOME", "+"), CREDIT("OUTCOME", "");

        private String text;
        private String sign;

        Category(String text, String sign){
            this.text = text;
            this.sign = sign;
        }

        public String getSign() {
            return sign;
        }

        public String getText() {
            return text;
        }
    }

    private Category category;

    public Transaction(User sender, User recipient, Integer amount){

        setAmount(amount);
        setSender(sender);
        setRecipient(recipient);
        identifier = UUID.randomUUID();

        if (amount < 0){
            setCategory(category.CREDIT);
        } else {
            setCategory(category.DEBIT);
        }
    }

    public static Transaction createTransaction(User recipient, User sender, Integer amount){
        if ((amount < 0 && recipient.getBalance() >= -amount)
            || (amount > 0 && sender.getBalance() >= amount)){
            return  new Transaction(sender, recipient, amount);
        }
        return null;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    private void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    private void setSender(User sender) {
        this.sender = sender;
    }

    private void setAmount(Integer amount) {
        this.amount = amount;
    }

    private void setCategory(Category category) {
        this.category = category;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public Integer getAmount() {
        return amount;
    }

    @Override
    public String toString(){
        return this.sender.getName() + " -> " + this.recipient.getName() + ", "+ category.getSign() + amount + ", " + category.getText() + ", " + getIdentifier();
    }
}