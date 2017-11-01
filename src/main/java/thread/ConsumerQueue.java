package thread;

import java.util.concurrent.BlockingQueue;

/**
 * Created by akumar6 on 10/17/17.
 */
public class ConsumerQueue extends Thread {
    private final BlockingQueue queue;

    public ConsumerQueue(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println("First Value:" + queue.take());
            System.out.println("Second Value:" + queue.take());
            System.out.println("Third Value:" + queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
