import java.util.HashMap;
import java.util.Map;

public class java_38698_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_38698_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isPasswordValid(password)) {
            sessionMap.put(username, password);
        } else {
            System.out.println("Invalid password for user " + username);
        }
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    public boolean isValidSession(String username, String password) {
        return sessionMap.containsKey(username) && sessionMap.get(username).equals(password);
    }

    private boolean isPasswordValid(String password) {
        // This is a placeholder for a more complex password validation logic.
        // Here we only check if the password is at least 8 characters long.
        return password.length() >= 8;
    }
}