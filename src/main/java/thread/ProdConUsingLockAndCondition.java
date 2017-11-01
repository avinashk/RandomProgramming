package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by akumar6 on 10/13/17.
 */
public class ProdConUsingLockAndCondition {


    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerCheck pc = new ProducerConsumerCheck();

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

class ProducerConsumerCheck {

    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();
    private volatile boolean produced = false;

    public void produce() throws InterruptedException {
        int count = 0;
        try {
            lock.lock();
            while (count < 10) {
                if (produced) {
                    cond.await();
                } else {
                    System.out.println("Avinash");
                    count++;
                    produced = true;
                    cond.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        int count = 0;
        try {
            lock.lock();
            while (count < 10) {
                if (produced) {
                    System.out.println("Kumar");
                    produced = false;
                    count++;
                    cond.signal();
                } else {
                    cond.await();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
