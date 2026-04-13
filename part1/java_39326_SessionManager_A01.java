import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class java_39326_SessionManager_A01 {
    private ReentrantLock[] locks;

    public java_39326_SessionManager_A01(int numSessions) {
        locks = new ReentrantLock[numSessions];
        for (int i = 0; i < numSessions; i++) {
            locks[i] = new ReentrantLock();
        }
    }

    public void accessSession(int sessionId) {
        ReentrantLock lock = locks[sessionId];
        if (lock.tryLock(10, TimeUnit.SECONDS)) {
            try {
                // Perform session-related operations
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Session " + sessionId + " is busy.");
        }
    }

    public void releaseSession(int sessionId) {
        ReentrantLock lock = locks[sessionId];
        lock.lock();
        try {
            // Perform cleanup operations
        } finally {
            lock.unlock();
        }
    }
}