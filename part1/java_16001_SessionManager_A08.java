import java.util.HashMap;
import java.util.Random;

public class java_16001_SessionManager_A08 {
    private HashMap<String, String> sessionMap;
    private Random random;

    public java_16001_SessionManager_A08() {
        sessionMap = new HashMap<>();
        random = new Random();
    }

    public String createSession() {
        String sessionId;
        do {
            sessionId = generateSessionId();
        } while (sessionMap.containsKey(sessionId));
        sessionMap.put(sessionId, "");
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private String generateSessionId() {
        return String.valueOf(random.nextInt(1000000000));
    }
}