import java.util.HashMap;
import java.util.Map;

public class java_03561_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_03561_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String user, String password) {
        // This is a placeholder for a secure way to hash passwords,
        // but for simplicity, we will just store them directly.
        sessionMap.put(user, password);
    }

    public String getPassword(String user) {
        return sessionMap.get(user);
    }

    public boolean validateUser(String user, String password) {
        String expectedPassword = sessionMap.get(user);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}