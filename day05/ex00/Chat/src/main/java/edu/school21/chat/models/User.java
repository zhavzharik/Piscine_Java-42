package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {

    private Integer id;
    private  String login;
    private  String password;
    private List<Chatroom> rooms;
    private List<Chatroom> activeRooms;

    public User(Integer id, String login, String password, List<Chatroom> rooms, List<Chatroom> activeRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.rooms = rooms;
        this.activeRooms = activeRooms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Chatroom> getRooms() {
        return rooms;
    }

    public void setRooms(List<Chatroom> rooms) {
        this.rooms = rooms;
    }

    public List<Chatroom> getActiveRooms() {
        return activeRooms;
    }

    public void setActiveRooms(List<Chatroom> activeRooms) {
        this.activeRooms = activeRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getLogin(), user.getLogin()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getRooms(), user.getRooms()) && Objects.equals(getActiveRooms(), user.getActiveRooms());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getRooms(), getActiveRooms());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", rooms=" + rooms +
                ", activeRooms=" + activeRooms +
                '}';
    }
}
