import java.util.HashMap;
import java.util.Map;

public class java_41857_SessionManager_A07 {

    private Map<String, String> sessionMap;

    public java_41857_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String username, String password) {
        // This is a simple hashing technique for demonstration purposes. In real-world applications, use a more secure hash function.
        String hashedPassword = Integer.toString((int) password.hashCode());
        sessionMap.put(username, hashedPassword);
        return hashedPassword;
    }

    public String getSession(String username) {
        return sessionMap.get(username);
    }

    public boolean isValidSession(String username, String password) {
        String hashedPassword = sessionMap.get(username);
        // This is a simple comparison for demonstration purposes. In real-world applications, use a more secure comparison method.
        return hashedPassword != null && hashedPassword.equals(Integer.toString((int) password.hashCode()));
    }

    public void deleteSession(String username) {
        sessionMap.remove(username);
    }
}