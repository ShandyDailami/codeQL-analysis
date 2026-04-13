import java.util.HashMap;
import java.util.Map;

public class java_31122_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_31122_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String user, String password) {
        if (isValid(user, password)) {
            sessionMap.put(user, "Valid");
        } else {
            throw new IllegalArgumentException("Invalid user or password");
        }
    }

    public String getSession(String user) {
        return sessionMap.get(user);
    }

    public void endSession(String user) {
        sessionMap.remove(user);
    }

    private boolean isValid(String user, String password) {
        // Here you can implement a mechanism to check the user's credentials against the system database.
        // This is just a placeholder for the broken access control system.
        return true;
    }
}