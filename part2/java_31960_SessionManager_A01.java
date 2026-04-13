import java.util.HashMap;
import java.util.Random;

public class java_31960_SessionManager_A01 {
    private HashMap<Integer, String> sessionMap;
    private Random random;

    public java_31960_SessionManager_A01() {
        sessionMap = new HashMap<>();
        random = new Random();
    }

    public String createSession(String sessionData) {
        int sessionId = random.nextInt(); // Generate a random session ID
        sessionMap.put(sessionId, sessionData);
        return "Session created with ID: " + sessionId;
    }

    public String getSessionData(int sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(int sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean hasSession(int sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}