import java.util.HashMap;
import java.util.Map;

public class java_31016_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_31016_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        // Here you might want to hash the password before storing it in the session map
        // This is just a placeholder for real world use case
        sessionMap.put(username, password);
    }

    public String getPassword(String username) {
        // Here you might want to hash the password before returning it
        // This is just a placeholder for real world use case
        return sessionMap.get(username);
    }

    public void validateSession(String username, String password) {
        String storedPassword = sessionMap.get(username);
        if (storedPassword == null || !storedPassword.equals(password)) {
            throw new AuthFailureException();
        }
    }
}