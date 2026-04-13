import java.util.HashMap;
import java.util.Map;

public class java_27380_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_27380_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            throw new IllegalStateException("Session not found: " + sessionId);
        }
    }

    public void setSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void deleteSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            throw new IllegalStateException("Session not found: " + sessionId);
        }
    }

    public void integrityCheck() {
        for (Map.Entry<String, String> entry : sessionMap.entrySet()) {
            String sessionId = entry.getKey();
            String sessionData = entry.getValue();

            // Add your own logic for integrity check
            // For example, you might check if sessionData is the same as the sessionId
            if (sessionId.equals(sessionData)) {
                System.out.println("Integrity failure detected for session: " + sessionId);
            }
        }
    }
}