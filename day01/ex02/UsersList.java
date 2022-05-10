package ex02;

public interface UsersList {
    public void addUser(User user);
    public User getUserById(Integer identifier);
    public User getUserByIndex(Integer index);
    public int getNumberOfUsers();
}