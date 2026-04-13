import java.util.HashMap;
import java.util.Map;

public class java_40122_SessionManager_A03 {
    // Data structure to store sessions
    private Map<String, String> sessionMap;

    public java_40122_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    // Method to store session token
    public void storeSession(String token, String session) {
        sessionMap.put(token, session);
    }

    // Method to retrieve session from stored sessions
    public String getSession(String token) {
        return sessionMap.getOrDefault(token, null);
    }

    // Method to remove session from stored sessions
    public void removeSession(String token) {
        sessionMap.remove(token);
    }
}