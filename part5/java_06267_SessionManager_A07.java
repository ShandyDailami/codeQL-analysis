import java.util.HashMap;
import java.util.Random;

public class java_06267_SessionManager_A07 {
    private HashMap<String, String> sessionMap;
    private Random random;

    public java_06267_SessionManager_A07() {
        sessionMap = new HashMap<>();
        random = new Random();
    }

    public String createSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        return String.valueOf(random.nextLong());
    }
}