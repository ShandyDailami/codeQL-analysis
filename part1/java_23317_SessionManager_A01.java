import java.util.HashMap;
import java.util.Map;

public class java_23317_SessionManager_A01 {

    private Map<String, String> userPasswords;

    public java_23317_SessionManager_A01() {
        this.userPasswords = new HashMap<>();
        this.userPasswords.put("user1", "password1");
        this.userPasswords.put("user2", "password2");
    }

    public boolean validateUser(String username, String password) {
        if(userPasswords.containsKey(username) && userPasswords.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}

public class SessionManager {

    private SecurityManager securityManager;
    private Map<String, String> sessionTokens;

    public java_23317_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
        this.sessionTokens = new HashMap<>();
    }

    public String startSession(String username, String password) {
        if(securityManager.validateUser(username, password)) {
            String sessionToken = generateSessionToken();
            sessionTokens.put(sessionToken, username);
            return sessionToken;
        }
        return null;
    }

    public String generateSessionToken() {
        return "session_token_" + System.currentTimeMillis();
    }

    public String getUsernameBySessionToken(String sessionToken) {
        if(sessionTokens.containsKey(sessionToken)) {
            return sessionTokens.get(sessionToken);
        }
        return null;
    }
}