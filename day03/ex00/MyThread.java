public class MyThread extends Thread {

    private String name;
    private Integer count;

    public MyThread(String name, Integer count){
        this.name = name;
        this.count = count;
    }

    @Override
    public void run(){
        for (int i=0; i < count; i++){
            System.out.println(this.name);
        }
    }
}