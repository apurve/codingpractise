package leave.nucleus.threading.producerconsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockConsumer implements Consumer {

    private ReentrantLock lock = null;
    private LinkedList<Integer> list = null;
    private Condition condition = null;

    public ReentrantLockConsumer(LinkedList<Integer> list, ReentrantLock lock, Condition condition) {
        this.list = list;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public LinkedList<Integer> getList() {
        return list;
    }

    @Override
    public Lock getLock() {
        return lock;
    }

    @Override
    public void consume() throws InterruptedException {
        while (true) {
            try {
                getLock().lock();
                while (getList().size() == 0) {
                    System.out.println("List is empty, gonna wait now!");
                    condition.await();
                }
                System.out.println("Removed number : " + getList().removeFirst());
                condition.signal();
            } finally {
                getLock().unlock();
            }
            System.out.println("Queue size after removing :"+getList().size());
            Thread.sleep(500);
        }
    }
}
