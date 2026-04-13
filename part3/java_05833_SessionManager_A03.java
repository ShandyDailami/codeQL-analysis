import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class java_05833_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_05833_SessionManager_A03() {
        this.sessionMap = new HashMap<>();
    }

    public String createSession(String username, String password) {
        // For simplicity, we're not actually storing the passwords in memory
        // In a real-world application, you should store passwords hashed and not the plain text
        // You can use a library such as Bcrypt to hash passwords securely

        // In a real-world application, you should also implement authentication here
        // For simplicity, we're just checking if the password is correct
        if (username.equals("admin") && password.equals("password")) {
            return UUID.randomUUID().toString(); // Generate a random UUID for the session
        } else {
            return null;
        }
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}