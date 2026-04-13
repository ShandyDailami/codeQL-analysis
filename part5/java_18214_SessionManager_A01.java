import java.util.HashMap;
import java.util.Map;

public class java_18214_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_18214_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        // This is a security sensitive operation
        // We're using a simple password hashing method as example
        // In real-world applications, we'd use more secure and complex methods.
        String hashedPassword = hashPassword(userId);
        sessionMap.put("sessionId", hashedPassword);
    }

    public String getUserId(String sessionId) {
        // This is a security sensitive operation
        // We're using a simple password hashing method as example
        // In real-world applications, we'd use more secure and complex methods.
        String hashedPassword = sessionMap.get("sessionId");
        return hashPassword(hashedPassword);
    }

    private String hashPassword(String password) {
        // This is a simple hashing method for the purpose of this example
        // In real-world applications, we'd use more secure and complex methods.
        // For now, let's just hash the password
        return String.valueOf(password.hashCode());
    }
}