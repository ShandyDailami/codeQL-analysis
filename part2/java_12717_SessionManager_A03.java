import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.Guard;

public class java_12717_SessionManager_A03 implements Guard {

    private int activeSessions = 0;
    private final int MAX_SESSIONS;

    public java_12717_SessionManager_A03(int maxSessions) {
        MAX_SESSIONS = maxSessions;
    }

    @Override
    public void lock(String lockId) throws AccessDeniedException, SecurityException {
        if (activeSessions >= MAX_SESSIONS) {
            throw new AccessDeniedException("Maximum sessions reached");
        }
        activeSessions++;
    }

    @Override
    public void unlock(String lockId) throws AccessControlException {
        if (activeSessions == 0) {
            throw new AccessControlException("No sessions found");
        }
        activeSessions--;
    }

    @Override
    public boolean isLocked(String lockId) throws AccessControlException {
        return activeSessions > 0;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager(3);

        try {
            sessionManager.lock("lock1");
            sessionManager.lock("lock2");
            sessionManager.lock("lock3");
        } catch (AccessDeniedException | AccessControlException e) {
            e.printStackTrace();
        }

        try {
            sessionManager.unlock("lock1");
            sessionManager.unlock("lock2");
        } catch (AccessControlException e) {
            e.printStackTrace();
        }

        System.out.println("Active sessions: " + sessionManager.activeSessions);
    }
}