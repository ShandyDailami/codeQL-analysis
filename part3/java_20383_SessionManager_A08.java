import java.util.HashMap;
import java.util.Map;

public class java_20383_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_20383_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String user, String password) {
        if (isValidPassword(password)) {
            sessionMap.put(user, password);
        } else {
            throw new SecurityException("Invalid password for user: " + user);
        }
    }

    public void endSession(String user) {
        sessionMap.remove(user);
    }

    public String getSession(String user) {
        return sessionMap.get(user);
    }

    private boolean isValidPassword(String password) {
        // Here you would typically check the password against a database or some other external source of truth
        // For the sake of simplicity, this example just checks if the password is not empty
        return !password.isEmpty();
    }
}