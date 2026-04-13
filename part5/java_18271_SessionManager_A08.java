import java.util.concurrent.locks.ReentrantLock;

public class java_18271_SessionManager_A08 {

    private ReentrantLock lock = new ReentrantLock();

    private Session currentSession;

    public void openSession() {
        if (currentSession == null) {
            currentSession = new Session();
            System.out.println("Opening session with ID: " + currentSession.getId());
        } else {
            System.out.println("Closing previous session with ID: " + (currentSession.getId() - 1));
            currentSession.close();
            currentSession = new Session();
            System.out.println("Opening new session with ID: " + currentSession.getId());
        }
    }

    public void closeSession() {
        if (currentSession != null) {
            System.out.println("Closing session with ID: " + currentSession.getId());
            currentSession.close();
            currentSession = null;
        }
    }

    public void performSecuritySensitiveOperations() {
        lock.lock();
        try {
            // Security-sensitive operations here.
            // For example, checking for a user's role in the database,
            // updating sensitive data, etc.
            System.out.println("Performing security-sensitive operations...");
        } finally {
            lock.unlock();
        }
    }

    private static class Session {
        private static int sessionCount = 0;
        private int id;

        public java_18271_SessionManager_A08() {
            sessionCount++;
            id = sessionCount;
        }

        public int getId() {
            return id;
        }

        public void close() {
            sessionCount--;
        }
    }
}