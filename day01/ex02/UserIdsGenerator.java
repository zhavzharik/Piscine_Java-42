package ex02;

public class UserIdsGenerator {
    private Integer lastGeneratedId;
    private static UserIdsGenerator instance;

    private UserIdsGenerator(){
        lastGeneratedId = new Integer(0);
    }

    public static  UserIdsGenerator getInstance(){
        if (instance == null){
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public Integer generatedId(){
        lastGeneratedId += 1;
        return lastGeneratedId;
    }
}