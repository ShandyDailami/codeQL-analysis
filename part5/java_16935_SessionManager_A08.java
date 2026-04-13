import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class java_16935_SessionManager_A08 {
    private List<String> activeSessions;
    private Random random;

    public java_16935_SessionManager_A08() {
        activeSessions = new ArrayList<>();
        random = new Random();
    }

    public String startSession() {
        String sessionId = generateSessionId();
        activeSessions.add(sessionId);
        return sessionId;
    }

    public void endSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return activeSessions.contains(sessionId);
    }

    private String generateSessionId() {
        return String.valueOf(random.nextInt(1000000000));
    }
}