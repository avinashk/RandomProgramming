package thread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by akumar6 on 10/17/17.
 */
public class ProducerQueue extends Thread{
    private final BlockingQueue queue;

    public ProducerQueue(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run(){
        Random random = new Random();
        try {
            queue.put(random.nextInt(100));
            Thread.sleep(1000);
            queue.put(random.nextInt(100));
            Thread.sleep(1000);
            queue.put(random.nextInt(100));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
