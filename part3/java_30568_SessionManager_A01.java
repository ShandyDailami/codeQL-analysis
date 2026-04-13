import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class java_30568_SessionManager_A01 {

    private static SessionManager instance;

    private java_30568_SessionManager_A01() {}

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession() {
        long currentThreadId = Thread.currentThread().getId();
        long processId = ManagementFactory.getRuntimeMXBean().getProcessId();

        System.out.println("Session Started: Thread ID = " + currentThreadId + ", Process ID = " + processId);
    }

    public void endSession() {
        long currentThreadId = Thread.currentThread().getId();
        long processId = ManagementFactory.getRuntimeMXBean().getProcessId();

        System.out.println("Session Ended: Thread ID = " + currentThreadId + ", Process ID = " + processId);
    }
}