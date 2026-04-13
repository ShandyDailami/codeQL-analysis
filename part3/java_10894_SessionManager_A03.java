import java.util.HashMap;
import java.util.Map;

public class java_10894_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_10894_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String password) {
        // In a real application, you would typically hash the password for storage and compare hashed values
        // This is a simple example for illustrative purposes
        sessionMap.put(username, password);
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public void invalidateSession(String username) {
        sessionMap.remove(username);
    }
}