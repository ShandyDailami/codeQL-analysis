import java.util.HashMap;
import java.util.Map;

public class java_31684_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_31684_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userName, String password) {
        if (userName == null || userName.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("User name and password cannot be null or empty");
        }
        sessionMap.put(userName, password);
    }

    public String getSession(String userName) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
        return sessionMap.get(userName);
    }

    public void endSession(String userName) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("User name cannot be null or empty");
        }
        sessionMap.remove(userName);
    }
}