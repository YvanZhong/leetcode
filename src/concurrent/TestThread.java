package concurrent;

import java.io.PipedWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class TestThread {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }

        //管道
        PipedWriter out = new PipedWriter();
    }

    public static void main1(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t " + Thread.currentThread().isDaemon());
                System.out.println("t " + Thread.currentThread().getName());
                while (true) {
                    System.out.println("i am");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("interrupt");
                    }
                }
            }
        });


        /*System.out.println("main " + Thread.currentThread().isDaemon());
        System.out.println("main " + Thread.currentThread().getName());

        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            System.out.println("interrupt main");
        } finally {
            System.out.println("main exist");
        }*/

        thread.start();

    }

}
