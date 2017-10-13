package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by akumar6 on 10/13/17.
 */
public class ReentrantLockExample {

    public static void main(String[] args) throws InterruptedException {
        RunnerA runner = new RunnerA();
        Thread t1 = new Thread(() -> {
            try {
                runner.firstThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                runner.secondThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        runner.finished();
    }
}

class RunnerA {
    Lock lock = new ReentrantLock();
    private int c = 0;

    public void firstThread() throws InterruptedException {
        try {
            lock.lock();
            increment();
        }finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {
        try {
            lock.lock();
            increment();
        }finally {
            lock.unlock();
        }
    }

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            c++;
        }
    }

    public void finished() {
        System.out.println("Count is:" + c);
    }
}
