import java.util.HashMap;
import java.util.Map;

public class java_09912_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_09912_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isValid(username, password)) {
            sessionMap.put(username, password);
        } else {
            throw new SecurityFailureException("Invalid login attempt");
        }
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    private boolean isValid(String username, String password) {
        // Here you could add a method to check if the username and password
        // match those in the database. This is a security-sensitive operation.
        return username.equals("admin") && password.equals("password");
    }
}