import java.util.HashMap;
import java.util.Map;

public class java_29722_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_29722_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isPasswordStrong(password)) {
            sessionMap.put(username, password);
        } else {
            throw new IllegalArgumentException("Password is not strong enough. Minimum requirement is 8 characters long with a mix of uppercase, lowercase, numbers and special characters");
        }
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public void endSession(String username) {
        sessionMap.remove(username);
    }

    private boolean isPasswordStrong(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
    }
}