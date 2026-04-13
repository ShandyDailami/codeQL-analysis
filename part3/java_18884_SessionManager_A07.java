import java.util.HashSet;
import java.util.Set;

public class java_18884_SessionManager_A07 {
    private Set<String> activeSessions;

    public java_18884_SessionManager_A07() {
        activeSessions = new HashSet<>();
    }

    public void openSession(String sessionId) {
        if (!activeSessions.contains(sessionId)) {
            activeSessions.add(sessionId);
        }
    }

    public void closeSession(String sessionId) {
        if (activeSessions.contains(sessionId)) {
            activeSessions.remove(sessionId);
        }
    }

    public boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    public int getActiveSessionCount() {
        return activeSessions.size();
    }
}