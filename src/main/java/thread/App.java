package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by akumar6 on 10/11/17.
 */
public class App {
    static Runner runner = new Runner();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                runner.process();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                runner.process();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long startTime = System.currentTimeMillis();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner.finished();
        long endTime = System.currentTimeMillis();

        long l = endTime - startTime;
        System.out.println("Time Taken:" + l);

    }
}

class Runner {

    Random random = new Random();
    private List<Integer> firstList = new ArrayList<>();
    private List<Integer> secondList = new ArrayList<>();
    Lock lock = new ReentrantLock();

    public void stage1() throws InterruptedException {
        lock.lock();
        firstList.add(random.nextInt(100));
        lock.unlock();
    }

    public void stage2() throws InterruptedException {
        lock.lock();
        secondList.add(random.nextInt());
        lock.unlock();
    }

    public void finished() {
        System.out.println("List 1 size: " + firstList.size());
        System.out.println("List 2 size: " + secondList.size());
    }

    public void process() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            stage1();
            stage2();
        }
    }
}
