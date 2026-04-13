import java.util.HashMap;
import java.util.Map;

public class java_27548_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_27548_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String user, String password) {
        if (isPasswordValid(password)) {
            sessionMap.put(user, password);
        } else {
            throw new IllegalArgumentException("Invalid password");
        }
    }

    public String getSession(String user) {
        return sessionMap.get(user);
    }

    public void endSession(String user) {
        sessionMap.remove(user);
    }

    private boolean isPasswordValid(String password) {
        // Here, we're just checking if the password is the same as the user's username.
        // In a real-world application, you'd want to use a more secure method to check the password.
        return password.equals(user);
    }
}