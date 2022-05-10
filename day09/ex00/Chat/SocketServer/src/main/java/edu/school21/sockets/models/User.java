package edu.school21.sockets.models;

public class User {

    private Integer identifier;
    private  String email;

    public User() {}

    public User(Integer identifier, String email) {
        this.identifier = identifier;
        this.email = email;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "identifier=" + identifier +
                ", email='" + email + '\'' +
                '}';
    }
}
