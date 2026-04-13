import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class java_05090_SessionManager_A08 {
    private List<String> sessions;
    private SecureRandom random;

    public java_05090_SessionManager_A08() {
        sessions = new ArrayList<>();
        random = new SecureRandom();
    }

    public String createSession() {
        String sessionId = createSessionId();
        sessions.add(sessionId);
        return sessionId;
    }

    public boolean validateSession(String sessionId) {
        return sessions.contains(sessionId);
    }

    private String createSessionId() {
        return String.valueOf(random.nextLong());
    }
}