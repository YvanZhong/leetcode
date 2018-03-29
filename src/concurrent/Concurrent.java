package concurrent;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class Concurrent {

    ThreadLocal t = new ThreadLocal();

    Executor e = new Executor() {
        @Override
        public void execute(Runnable command) {

        }
    };

    Lock lock ;

    AbstractQueuedSynchronizer abstractQueuedSynchronizer;

    public interface trait {

    }

    LockSupport l ;

    CountDownLatch countDownLatch;

    Future future;

    ThreadPoolExecutor threadPoolExecutor;

}
