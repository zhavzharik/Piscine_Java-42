public class ProducerConsumer {
    private Integer check;
    private Integer count;

    public ProducerConsumer(Integer count){
        this.check = 0;
        this.count = count;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    public Integer getCheck() {
        return check;
    }

    public void produce(Integer count) throws InterruptedException {
        while (count > 0) {
            synchronized (this) {
                while (getCheck() == 1) {
                    wait();
                }
                System.out.println("Egg");
                count--;
                setCheck(1);
                notify();
            }
        }
    }

    public void consume(Integer count) throws InterruptedException {
        while (count > 0) {
            synchronized (this) {
                while (getCheck() == 0) {
                    wait();
                }
                System.out.println("Hen");
                count--;
                setCheck(0);
                notify();
            }
        }
    }
}