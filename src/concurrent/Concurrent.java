package concurrent;

import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class Concurrent {

    ThreadLocal t = new ThreadLocal();

    Executor e = new Executor() {
        @Override
        public void execute(Runnable command) {

        }
    };

    Lock lock ;

    ReentrantLock reentrantLock;

    ReentrantReadWriteLock reentrantReadWriteLock;

    Object object;

    AbstractQueuedSynchronizer abstractQueuedSynchronizer;

    public interface trait {

    }

    LockSupport l ;

    CountDownLatch countDownLatch;

    Future future;

    static ThreadPoolExecutor threadPoolExecutor;

    BlockingQueue blockingQueue;

    public static class Test{

    }

    public static void main(String... args) {
        /*LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
        int i = 1;
        //int[] arr = new int[Integer.MAX_VALUE / 4];
        ArrayList<Integer> a = new ArrayList<Integer>(Integer.MAX_VALUE/5);
        linkedBlockingQueue.addAll(a);
        while (true) {
            linkedBlockingQueue.add(i++);
            System.out.println(a.size());
        }*/

        //PriorityBlockingQueue<Test> priorityBlockingQueue = new PriorityBlockingQueue<>();

        //priorityBlockingQueue.add(new Test()); //java.lang.ClassCastException

        DelayQueue delayQueue;

        SynchronousQueue synchronousQueue;

        LinkedTransferQueue linkedTransferQueue;

        ForkJoinPool forkJoinPool;

        CountDownLatch countDownLatch;

        CyclicBarrier cyclicBarrier;

        Semaphore semaphore;

        Exchanger exchanger;

        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        Runnable r = new Runnable() {
            @Override
            public void run() {

            }
        };

        Future<?> t = threadPoolExecutor.submit(r);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        scheduledExecutorService.schedule(r, 0, TimeUnit.MILLISECONDS);

        Integer.valueOf(5);

        Short.valueOf((short)5);

        Byte.valueOf((byte)5);

        Long.valueOf(5L);

        Boolean.valueOf(true);

        System.out.println(Runtime.getRuntime().availableProcessors());

        //testThreadInterrupt();
    }

    public static void main2(String[] args) {
        testThreadInterrupt();
    }

    private static void testThreadInterrupt() {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true && !Thread.currentThread().isInterrupted()) {
                    //run();
                    try {
                        Thread.sleep(1000);
                        System.out.println("working");
                    } catch (InterruptedException e) {

                    }
                }
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();
        thread.start(); //抛异常



        try {
            Thread.sleep(2000);

            thread.interrupt();
            System.out.println("interrupted!!!");

            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
    }


}
