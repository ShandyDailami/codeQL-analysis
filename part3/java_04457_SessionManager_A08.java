import java.util.HashMap;
import java.util.Map;

public class java_04457_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_04457_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            // Handle IntegrityFailure here (e.g., throw an exception or return a default value)
            // This is a placeholder for a real implementation
            return "Session not found";
        }
    }

    public void removeSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
        } else {
            // Handle IntegrityFailure here (e.g., throw an exception or return a default value)
            // This is a placeholder for a real implementation
            System.out.println("Session not found");
        }
    }
}