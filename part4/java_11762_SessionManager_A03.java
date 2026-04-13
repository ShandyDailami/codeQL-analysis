import java.util.HashMap;
import java.util.Map;

public class java_11762_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_11762_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userName, String password) {
        // Storing passwords in plaintext for simplicity. 
        // This should never be done in a real application.
        sessionMap.put(userName, password);
    }

    public String getSession(String userName) {
        return sessionMap.get(userName);
    }

    public void removeSession(String userName) {
        sessionMap.remove(userName);
    }
}