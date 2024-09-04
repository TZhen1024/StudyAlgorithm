package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CreateThreadTry {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1，直接使用Thread，重写run方法
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                System.out.println("This is t1");
            }
        };
        t1.start();

        // 2，Runnable配合Thread，线程与任务分开
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("This is t2");
            }
        };
        // lambda精简代码
        // Runnable runnable = () -> System.out.println("This is t2");
        Thread t2 = new Thread(runnable, "t2");
        t2.start();

        // 3, Future配合Thread，能够处理有返回值的情况
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("This is t3");
                Thread.sleep(1000);
                return 100;
            }
        });

        Thread t3 = new Thread(task, "t3");
        t3.start();
        System.out.println(task.get());
    }
}
