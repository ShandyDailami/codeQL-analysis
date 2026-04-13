import java.util.HashSet;
import java.util.Set;

public class java_24819_SessionManager_A08 {
    private Set<String> activeSessions;

    public java_24819_SessionManager_A08() {
        activeSessions = new HashSet<>();
    }

    public synchronized void openSession() {
        String sessionId = String.valueOf(System.currentTimeMillis());
        while (activeSessions.contains(sessionId)) {
            sessionId = String.valueOf(System.currentTimeMillis());
        }
        activeSessions.add(sessionId);
    }

    public synchronized void closeSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public synchronized boolean hasActiveSession(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public static void main(String[] args) {
        UniqueSessionManager manager = new UniqueSessionManager();

        manager.openSession();
        manager.openSession();
        manager.closeSession("123");
        System.out.println(manager.hasActiveSession("456"));
        manager.openSession();
        System.out.println(manager.hasActiveSession("789"));
    }
}