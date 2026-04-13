import java.util.LinkedHashMap;
import java.util.Map;

public class java_20097_SessionManager_A08 {
    // LinkedHashMap will maintain the order of elements
    private Map<String, String> sessionMap;

    public java_20097_SessionManager_A08() {
        sessionMap = new LinkedHashMap<>();
    }

    // Method to create a session
    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    // Method to retrieve a session
    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    // Method to delete a session
    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // Method to clean the session map
    public void cleanSessions() {
        sessionMap.clear();
    }

    // Method to check if a session exists
    public boolean hasSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    // Method to get the size of the session map
    public int getSize() {
        return sessionMap.size();
    }
}