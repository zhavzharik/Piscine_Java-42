public class Egg implements Runnable {

    private Integer count;
    private ProducerConsumer pc;

    public Egg(Integer count, ProducerConsumer pc){
        this.count = count;
        this.pc = pc;
    }

    @Override
    public void run(){
        try {
            pc.produce(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}