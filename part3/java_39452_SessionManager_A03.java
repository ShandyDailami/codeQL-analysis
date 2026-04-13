import javax.management.RuntimeErrorException;
import java.util.HashMap;
import java.util.Map;

public class java_39452_SessionManager_A03 {
    private Map<String, String> sessionMap;
    private Map<String, String> passwordMap;

    public java_39452_SessionManager_A03() {
        sessionMap = new HashMap<>();
        passwordMap = new HashMap<>();
    }

    public String createSession(String username, String password) {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new RuntimeErrorException(new Throwable("Invalid username or password"));
        }
        if (password.length() < 8) {
            throw new RuntimeErrorException(new Throwable("Password must be at least 8 characters long"));
        }

        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        passwordMap.put(sessionId, hashPassword(password));

        return sessionId;
    }

    public String getUsername(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new RuntimeErrorException(new Throwable("Invalid sessionId"));
        }

        return sessionMap.get(sessionId);
    }

    public String getPassword(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new RuntimeErrorException(new Throwable("Invalid sessionId"));
        }

        return passwordMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        if (sessionId == null || sessionId.isEmpty()) {
            throw new RuntimeErrorException(new Throwable("Invalid sessionId"));
        }

        sessionMap.remove(sessionId);
        passwordMap.remove(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder for a real implementation
        return "A03_SESSION_" + System.nanoTime();
    }

    private String hashPassword(String password) {
        // This is a placeholder for a real implementation
        // In a real implementation, you would need to use a secure hashing algorithm
        // This is left as an example and does not cover the security aspect
        return password;
    }
}