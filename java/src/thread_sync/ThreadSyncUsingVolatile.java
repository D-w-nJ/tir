package thread_sync;

public class ThreadSyncUsingVolatile {
    volatile boolean flag = true;

    public void test() {
        new Thread(() -> {
            System.out.println("Thread1 starts");
            int count = 0;
            while (flag) {
                count++;
            }
            System.out.println("Thread1 finished");
        }).start();

        new Thread(() -> {
            System.out.println("Thread2 starts");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2 finished");
            flag = false;
        }).start();
    }

    public static void main(String[] args) {
        ThreadSyncUsingVolatile test = new ThreadSyncUsingVolatile();
        test.test();

    }
}

/*
결과:

Thread1 starts
Thread2 starts
Thread2 finished
Thread1 finished

 */
