public class Action {

    private Thread egg;
    private Thread hen;
    private final ProducerConsumer pc;


    public Action(Integer count) {
        this.pc = new ProducerConsumer(count);
        this.egg = new Thread(new Egg(count, pc));
        this.hen = new Thread(new Hen(count, pc));
    }

    public void orchestrate() throws InterruptedException {
        this.egg.start();
        this.hen.start();

        this.egg.join();
        this.hen.join();
    }
}