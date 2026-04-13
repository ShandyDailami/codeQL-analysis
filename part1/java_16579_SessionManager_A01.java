import java.util.HashMap;
import java.util.Map;

public class java_16579_SessionManager_A01 {
    private Map<String, String> userPasswords;

    public java_16579_SessionManager_A01() {
        userPasswords = new HashMap<>();
        userPasswords.put("user1", "password1");
        userPasswords.put("user2", "password2");
        userPasswords.put("user3", "password3");
    }

    public String getPassword(String user) {
        return userPasswords.get(user);
    }

    public boolean checkPassword(String user, String password) {
        String correctPassword = userPasswords.get(user);
        return correctPassword != null && correctPassword.equals(password);
    }
}

public class SessionManager {
    private SecurityManager securityManager;
    private Map<String, String> sessionUsers;

    public java_16579_SessionManager_A01(SecurityManager securityManager) {
        this.securityManager = securityManager;
        sessionUsers = new HashMap<>();
    }

    public String createSession(String user) {
        if (!securityManager.checkPassword(user, "correctPassword")) {
            return "Access Denied";
        }

        String sessionId = "session" + sessionUsers.size();
        sessionUsers.put(sessionId, user);
        return sessionId;
    }

    public String getUser(String sessionId) {
        return sessionUsers.get(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();
        SessionManager sessionManager = new SessionManager(securityManager);

        String sessionId = sessionManager.createSession("user1");
        System.out.println("Session created: " + sessionId);

        String user = sessionManager.getUser(sessionId);
        System.out.println("User who created the session: " + user);
    }
}