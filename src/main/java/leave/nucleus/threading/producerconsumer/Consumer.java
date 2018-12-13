package leave.nucleus.threading.producerconsumer;

import java.util.LinkedList;

public interface Consumer extends ListProvider, LockProvider {

    default void consume() throws InterruptedException {
        while (true) {
            synchronized (getLock()) {
                while (getList().size() == 0)
                    getLock().wait();
                System.out.println("Queue size before taking :" + getList().size());
                Integer value = getList().removeFirst();
                System.out.println("Took value :"+value);
                getLock().notify();
            }
            Thread.sleep(500);
        }
    }

}