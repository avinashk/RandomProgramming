package thread;

/**
 * Created by akumar6 on 10/11/17.
 */
public class Processor {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();

        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

class ProducerConsumer {
    private Object lock = new Object();
    private volatile boolean produced = false;

    public void produce() throws InterruptedException {
        int count = 0;
        synchronized (lock) {
            while (count < 10) {
                if(produced){
                    lock.wait();
                }else{
                    System.out.println("Avinash");
                    count++;
                    produced = true;
                    lock.notify();
                }
            }

        }
    }

    public void consume() throws InterruptedException {
        int count =0;
        synchronized (lock){
            while (count < 10) {
                if (produced) {
                    System.out.println("Kumar");
                    produced = false;
                    count++;
                    lock.notify();
                }else{
                    lock.wait();
                }
            }
        }
    }
}




