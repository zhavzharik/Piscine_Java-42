package ex01;

public class Program {

    public static void main(String[] args){
        User dog = new User("Rex", 5000);
        User cat = new User("Tom", 4000);
        User mouse = new User("Jerry", 3000);

        System.out.println(dog);
        System.out.println(cat);
        System.out.println(mouse);

        UserIdsGenerator next = UserIdsGenerator.getInstance();
        System.out.println("Next Id: " + next.generatedId());
    }
}