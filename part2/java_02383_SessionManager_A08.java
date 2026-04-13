import java.util.HashMap;
import java.util.Map;

public class java_02383_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_02383_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String user, String password) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, user);
        return sessionId;
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getUser(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private String generateSessionId() {
        // This is a placeholder, replace with a real session ID generation
        return "sessionId";
    }

    public boolean checkIntegrity(String sessionId, String password) {
        String user = sessionMap.get(sessionId);
        return user != null && user.equals(password);
    }
}

public class Main {
    public static void main(String[] args) {
        SecurityManager securityManager = new SecurityManager();

        String sessionId = securityManager.createSession("user1", "password1");
        System.out.println("Created session with ID: " + sessionId);

        String user = securityManager.getUser(sessionId);
        System.out.println("User in session: " + user);

        boolean integrityCheck = securityManager.checkIntegrity(sessionId, "password1");
        System.out.println("Integrity check result: " + integrityCheck);

        securityManager.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);
    }
}