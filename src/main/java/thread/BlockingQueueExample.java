package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by akumar6 on 10/17/17.
 */
public class BlockingQueueExample {



    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        ProducerQueue producer = new ProducerQueue(queue);
        ConsumerQueue consumer = new ConsumerQueue(queue);

        producer.start();
        consumer.start();

        System.out.println("Waiting for threads to finish:");

        producer.join();
        consumer.join();

    }


}
