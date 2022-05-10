package ex02;

public class Program {

    public static void main(String[] args) {

        UsersList animals = new UsersArrayList();
        User dog = new User("Rex", 5000);
        User cat = new User("Tom", 4000);
        User mouse = new User("Jerry", 3000);
        User tiger = new User("Ben", 30000);

        animals.addUser(dog);
        animals.addUser(cat);
        animals.addUser(mouse);

        System.out.println("Count: " + animals.getNumberOfUsers());
        try {
            User tmp = animals.getUserById(2);
            System.out.println(tmp);
        } catch (UserNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            User tmp = animals.getUserById(5);
            System.out.println(tmp);
        } catch (UserNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            User tmp = animals.getUserByIndex(2);
            System.out.println(tmp);
        } catch (UserNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            User tmp = animals.getUserByIndex(5);
            System.out.println(tmp);
        } catch (UserNotFoundException e){
            System.out.println(e.getMessage());
        }

        UserIdsGenerator next = UserIdsGenerator.getInstance();
        System.out.println("Next Id: " + next.generatedId());
    }
}