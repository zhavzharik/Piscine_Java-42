package ex02;

class UserNotFoundException extends RuntimeException{}

public class UsersArrayList implements UsersList {
    private User[] array;
    private Integer count;
    private static final int DEFAULT_ARRAY_SIZE = 10;

    public UsersArrayList(){
        array = new User[DEFAULT_ARRAY_SIZE];
        count = 0;
    }

    public void addUser(User user){
        array[count] = user;
        count++;
        increased();
    }

    private void increased() {
        if (array.length == count){
            User[] tmp = new User[count + count];

            for (int i=0; i < count; i++){
                tmp[i] = array[i];
            }
            array = tmp;
        }
    }

    public User getUserById(Integer identifier){
        for (int i=0; i < count; i++) {
            if (array[i].getIdentifier() == identifier) {
                return array[i];
            }
        }
        throw new UserNotFoundException();
    }

    public User getUserByIndex(Integer index){
        if (index <= count && index >= 0){
            return array[index];
        }
        throw new UserNotFoundException();
    }

    public int getNumberOfUsers(){
        return count;
    }
}

