import java.util.HashMap;
import java.util.Map;

public class java_04386_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_04386_SessionManager_A01() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public String getPassword(String userName) {
        return userMap.get(userName);
    }

    public boolean isValidUser(String userName, String password) {
        if (userMap.containsKey(userName)) {
            return userMap.get(userName).equals(password);
        }
        return false;
    }
}

public class SessionManager {
    private SecurityManager securityManager;

    public java_04386_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public String getSessionId(String userName, String password) {
        if (securityManager.isValidUser(userName, password)) {
            // Create session and return session id
            String sessionId = "session123";
            return sessionId;
        } else {
            return null;
        }
    }
}