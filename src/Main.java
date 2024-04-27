
/**
 * <h1>Creating a simple Deadlock in Java</h1>
 *
 * <p><code>Thread 1</code> acquires the first <code>lock</code> and sleeps for <code>100ms</code>.
 * In the meantime <code>Thread 2</code> acquires the second <code>lock</code> and sleeps for <code>100ms</code> too.</p>
 *
 * <p>Since both threads have obtained the respective <code>locks</code>, the inner synchronized block cannot
 * be executed. Therefore, both threads are left waiting for the other <code>lock</code> to be released, resulting
 * in an indefinite wait or what is typically known as a <b><font color="red">deadlock</font></b>.</p>
 */
public class Main {

    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(() -> {

            synchronized (lock1) {
                System.out.println("Thread 1 is holding lock 1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock2) {
                    System.out.println("Thread 1 is holding lock 2");
                    System.out.println("This will never happen!");
                }
            }
        });

        Thread t2 = new Thread(() -> {

            synchronized (lock2) {
                System.out.println("Thread 2 is holding lock 2");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock1) {
                    System.out.println("Thread 2 is holding lock 1");
                    System.out.println("This will never happen!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}