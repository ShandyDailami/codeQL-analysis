import java.util.HashMap;
import java.util.Map;

public class java_32339_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_32339_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        // This is a simple example of a security-sensitive operation
        // It uses a placeholder password for simplicity. In a real application,
        // you would want to hash and salt the password, not store it in plain text.
        if (password.equals("password")) {
            sessionMap.put(username, password);
        }
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }
}