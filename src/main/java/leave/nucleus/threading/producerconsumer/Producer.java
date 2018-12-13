package leave.nucleus.threading.producerconsumer;

public interface Producer extends ListProvider, LockProvider {

    int LIMIT_OF_LIST = 10;

    default void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (getLock()) {
                System.out.println("Queue size before producing : " + getList().size());
                while (getList().size() == LIMIT_OF_LIST)
                    getLock().wait();
                getList().add(value++);
                getLock().notify();
            }
            Thread.sleep(400);
        }
    }

}