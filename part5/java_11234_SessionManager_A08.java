import java.util.HashMap;
import java.util.Random;

public class java_11234_SessionManager_A08 {
    private HashMap<String, String> sessionMap;
    private Random random;

    public java_11234_SessionManager_A08() {
        sessionMap = new HashMap<>();
        random = new Random();
    }

    public String createSession() {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public boolean checkSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void closeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    private String generateSessionId() {
        return String.valueOf(random.nextLong());
    }
}