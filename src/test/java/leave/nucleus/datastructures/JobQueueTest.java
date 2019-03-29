package leave.nucleus.datastructures;

import org.junit.Assert;
import org.junit.Test;

public class JobQueueTest {

    @Test
    public void testAssignedWorkers1() {
        JobQueue jobQueue = new JobQueue();
        jobQueue.setNumWorkers(2);
        jobQueue.setJobs(new long[] {1,2,3,4,5});
        jobQueue.assignJobs();
        Assert.assertArrayEquals(new int[] {0,1,0,1,0}, jobQueue.getAssignedWorker());
        Assert.assertArrayEquals(new long[] {0,0,1,2,4}, jobQueue.getStartTime());
    }

    @Test
    public void testAssignedWorkers2() {
        JobQueue jobQueue = new JobQueue();
        jobQueue.setNumWorkers(4);
        long[] jobs = new long[20];
        for (int index = 0; index < 20; index++) {
            jobs[index] = 1;
        }
        jobQueue.setJobs(jobs);
        jobQueue.assignJobs();
        Assert.assertArrayEquals(new int[] {0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3}, jobQueue.getAssignedWorker());
        Assert.assertArrayEquals(new long[] {0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4}, jobQueue.getStartTime());
    }

}