package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWithExecutorService{

    public static void main(String[] args) {
        RunnerB runner = new RunnerB();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.execute();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executorService.submit(t1);
        }
        executorService.shutdown();
        runner.finished();
    }

}

class RunnerB {
    Lock lock = new ReentrantLock();
    private int c = 0;

    public void execute() throws InterruptedException {
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
