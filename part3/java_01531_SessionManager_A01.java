import java.util.HashMap;
import java.util.Map;

public class java_01531_SessionManager_A01 {
    private Map<String, String> userPasswords = new HashMap<>();

    public java_01531_SessionManager_A01() {
        userPasswords.put("user1", "password1");
        userPasswords.put("user2", "password2");
    }

    public boolean checkPassword(String user, String password) {
        String correctPassword = userPasswords.get(user);
        return correctPassword != null && correctPassword.equals(password);
    }
}

public class SessionManager {
    private SecurityManager securityManager;
    private Map<String, String> sessionUsers = new HashMap<>();

    public java_01531_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public String startSession(String user, String password) throws Exception {
        if (!securityManager.checkPassword(user, password)) {
            throw new Exception("Invalid username or password");
        }

        String sessionId = generateSessionId();
        sessionUsers.put(sessionId, user);

        return sessionId;
    }

    public String getUserFromSession(String sessionId) throws Exception {
        String user = sessionUsers.get(sessionId);
        if (user == null) {
            throw new Exception("Invalid session");
        }

        return user;
    }

    private String generateSessionId() {
        // This is a placeholder for a real session ID generation
        return "session123";
    }
}