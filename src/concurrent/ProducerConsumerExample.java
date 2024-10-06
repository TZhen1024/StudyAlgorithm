import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5); // 创建大小为5的缓冲区

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }

}
class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;
    private final int MAX_SIZE = 5; //缓冲区最大容量

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                produce(i); //生产物品
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void produce(int item) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == MAX_SIZE) {
                System.out.println("缓冲区已满，生产者等待");
                queue.wait(); // 如果缓冲区已满，生产者线程等待（锁queue，所以queue.wait)
            }

            queue.put(item); // 将物品放入缓冲区
            System.out.println("生产者生产物品: " + item);
            queue.notifyAll();
        }
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                consume(); // 消费物品
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void consume() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                System.out.println("缓冲区为空，消费者等待...");
                queue.wait();
            }

            int item = queue.take(); // 从缓冲区取出物品
            System.out.println("消费者消费物品：" + item);
            queue.notifyAll(); // 唤醒所有等待的消费者进程
        }
    }
}