import java.util.HashMap;
import java.util.Map;

public class java_35033_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_35033_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Additional methods for security-sensitive operations related to A03_Injection can be added here

    // Example method to check if an injection attempt is successful
    public boolean isInjectionSafe(String userInput) {
        try {
            // Try to add session with user input as session data
            this.addSession("sessionId", userInput);
            // If the session data is successfully added, the injection attempt is successful
            return true;
        } catch (Exception e) {
            // In case of an exception, the injection attempt is not successful
            return false;
        }
    }
}