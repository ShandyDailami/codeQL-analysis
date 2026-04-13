import java.util.HashMap;
import java.util.Map;

public class java_08138_SessionManager_A01 {
    private Map<String, String> sessions;

    public java_08138_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void createSession(String username, String password) {
        if (isPasswordWeak(password)) {
            System.out.println("Sorry, but the password is weak. It will not be stored.");
            return;
        }
        sessions.put(username, password);
    }

    public String getSession(String username) {
        return sessions.get(username);
    }

    public void destroySession(String username) {
        sessions.remove(username);
    }

    private boolean isPasswordWeak(String password) {
        // Assume weak passwords are less than 6 characters long
        return password.length() < 6;
    }
}