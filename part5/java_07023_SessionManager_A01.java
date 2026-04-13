import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class java_07023_SessionManager_A01 {

    private static final ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();
    private static final long threadCount = threadMxBean.getThreadCount();
    private static long currentThreadCount = 0;
    private static final long MAX_THREAD_COUNT = 10000; // You can set the maximum thread count according to your requirement

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            long threadId = threadMxBean.getThreadName(threadMxBean.findDeadlockedThreads().toArray()[0])[1];
            printSessionInfo(threadId);
            Thread.sleep(5000); // Sleep for 5 seconds
        }
    }

    private static void printSessionInfo(long threadId) {
        System.out.println("Thread ID: " + threadId);
        System.out.println("Thread Count: " + currentThreadCount);
        System.out.println("Max Thread Count: " + MAX_THREAD_COUNT);
        System.out.println("Percentage Utilized: " + (currentThreadCount / (double) threadCount) * 100 + "%");
        System.out.println("-------------------------");
    }
}