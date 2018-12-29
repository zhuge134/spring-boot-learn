import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class InterruptTest {

    private Object lock;

    private CountDownLatch t1InSync;

    private CountDownLatch t2InSync;

    @Before
    public void setLock() {
        lock = new Object();
        t1InSync = new CountDownLatch(1);
        t2InSync = new CountDownLatch(1);
    }

    @Test
    public void test() {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        t1.start();
        try {
            t1InSync.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*t2.start();
        try {
            t2InSync.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        /*System.out.println("interrupt T1");
        t1.interrupt();*/

        System.out.println("notify T1");
        synchronized (lock) {
            lock.notifyAll();
        }

        int flag = 0;
        try {
            flag = System.in.read();
            if (0 == flag) {
                System.exit(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private class T2 implements Runnable {

        @Override
        public void run() {
            System.out.println("T2 begin");
            synchronized (lock) {
                t2InSync.countDown();
                System.out.println("T2 in sync");
                while (true) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private class T1 implements Runnable {

        private boolean stop;

        @Override
        public void run() {
            System.out.println("T1 begin");
            while (!stop) {
                synchronized (lock) {
                    t1InSync.countDown();
                    System.out.println("T1 in sync");
                    try {
                        lock.wait();
                        System.out.println("T1 awaked !");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("T1 is interrupted!");
                    }
                    stop = true;
                }
                System.out.println("T1 leave sync !");
            }
        }
    }

}
