public class Hen implements Runnable {

    private Integer count;
    private ProducerConsumer pc;

    public Hen(Integer count, ProducerConsumer pc){
        this.count = count;
        this.pc = pc;
    }

    @Override
    public void run(){
        try {
            pc.consume(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}