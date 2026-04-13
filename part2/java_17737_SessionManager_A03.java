import java.util.ArrayList;
import java.util.List;

public class java_17737_SessionManager_A03 {
    private List<String> sessions;
    private int sessionCount;

    public java_17737_SessionManager_A03() {
        sessions = new ArrayList<>();
        sessionCount = 0;
    }

    public String createSession() {
        String sessionId = "S" + (sessionCount++);
        sessions.add(sessionId);
        return sessionId;
    }

    public boolean validateSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            return false;
        }
        return sessions.contains(sessionId);
    }
}