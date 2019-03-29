import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JobQueue {

    private int numWorkers;
    private long[] jobs;

    private int[] assignedWorker;
    private long[] startTime;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numWorkers = in.nextInt();
        int m = in.nextInt();
        jobs = new long[m];
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        for (int i = 0; i < jobs.length; ++i) {
            out.println(assignedWorker[i] + " " + startTime[i]);
        }
    }

    public void assignJobs() {
        assignedWorker = new int[jobs.length];
        startTime = new long[jobs.length];
        PriorityQueue<Worker> workers = new PriorityQueue<Worker>(new Comparator<Worker>() {
            @Override
            public int compare(Worker o1, Worker o2) {
                if(o1.nextFreeTime.equals(o2.nextFreeTime))
                    return o1.id.compareTo(o2.id);
                return o1.nextFreeTime.compareTo(o2.nextFreeTime);
            }
        });

        for(int worker = 0; worker < numWorkers; worker++)
            workers.add(new Worker(worker, Long.valueOf(0)));

        for (int i = 0; i < jobs.length; i++) {
            long duration = jobs[i];
            Worker bestWorker = workers.remove();
            assignedWorker[i] = bestWorker.id;
            startTime[i] = bestWorker.nextFreeTime;
            workers.add(new Worker(bestWorker.id, bestWorker.nextFreeTime += duration));
        }
    }

    class Worker {
        public Worker(Integer id, Long nextFreeTime){
            this.id = id;this.nextFreeTime=nextFreeTime;
        }
        public Integer id;
        public Long nextFreeTime;
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        if(numWorkers > 0 && jobs.length > 0)
            assignJobs();
        writeResponse();
        out.close();
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public int[] getAssignedWorker() {
        return assignedWorker;
    }

    public long[] getStartTime() {
        return startTime;
    }

    public void setNumWorkers(int numWorkers) {
        this.numWorkers = numWorkers;
    }

    public void setJobs(long[] jobs) {
        this.jobs = jobs;
    }
}