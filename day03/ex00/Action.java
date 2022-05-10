public class Action {

    private Thread hen;
    private Thread egg;

    public Action(Integer count) {
        this.hen = new MyThread("Hen", count);
        this.egg = new MyThread("Egg", count);
    }

    public void play() {
        hen.start();
        egg.start();

        try {
            hen.join();
            egg.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}