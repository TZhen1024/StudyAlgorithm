public class ParityPrinter {
    // 线程共享变量，总打印次数
    private int max;
    // 线程共享变量，表示打印次数
    private int number = 1;
    //线程共享变量，表示是否已打印过奇数
    private boolean odd;

    public ParityPrinter(int max) {
        this.max = max;
    }

    // 打印奇数
    public synchronized void printOdd() {
        while (number < max) {
            while (odd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + number);
            number++;
            odd = true;
            notify();
        }
    }

    // 打印偶数
    public synchronized void printEven() {
        while (number < max) {
            while (!odd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": " + number);
            number++;
            odd = false;
            notify();
        }
    }

    public static void main(String[] args) {
        ParityPrinter printer = new ParityPrinter(100);
        // 创建两个线程，分别传入不同的Runnable对象
        Thread t1 = new Thread(printer::printOdd);
        Thread t2 = new Thread(printer::printEven);

        t1.start();
        t2.start();
    }
}
