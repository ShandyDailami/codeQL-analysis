import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class java_35164_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private Random random;

    public java_35164_SessionManager_A08() {
        sessionMap = new HashMap<>();
        random = new Random();
    }

    public String createSession(String data) {
        String sessionKey = generateSessionKey();
        sessionMap.put(sessionKey, data);
        return sessionKey;
    }

    public String getSessionData(String sessionKey) {
        if (sessionMap.containsKey(sessionKey)) {
            return sessionMap.get(sessionKey);
        } else {
            // Handle session not found
            return null;
        }
    }

    public boolean validateSession(String sessionKey, String expectedData) {
        if (sessionMap.containsKey(sessionKey)) {
            return sessionMap.get(sessionKey).equals(expectedData);
        } else {
            // Handle session not found
            return false;
        }
    }

    public void deleteSession(String sessionKey) {
        if (sessionMap.containsKey(sessionKey)) {
            sessionMap.remove(sessionKey);
        }
    }

    private String generateSessionKey() {
        return String.valueOf(random.nextLong());
    }
}