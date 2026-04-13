import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Random;

public class java_36950_SessionManager_A08 {
    private static final String[] SESSION_IDS = {"session1", "session2", "session3", "session4", "session5"};
    private static final Random random = new Random();

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.start();
    }

    private void start() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        while (true) {
            long[] threadIds = threadMXBean.getAllThreadIds();
            for (long threadId : threadIds) {
                ThreadInfo threadInfo = threadMXBean.getThreadInfo(threadId);
                System.out.println("Thread: " + threadInfo.getThreadName() + ", Session ID: " + getSessionId(threadInfo.getThreadName()));
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getSessionId(String threadName) {
        int hash = threadName.hashCode();
        hash = 31 * hash + (random.nextInt(1000));
        return SESSION_IDS[hash % SESSION_IDS.length];
    }
}