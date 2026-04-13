import java.util.HashMap;

public class java_25931_SessionManager_A01 {
    private HashMap<String, String> sessionMap;
    private SecurityManager securityManager;

    public java_25931_SessionManager_A01() {
        sessionMap = new HashMap<>();
        securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
                // Implementing access control logic
                if (perm.getName().equals("access control")) {
                    throw new SecurityException("Access Denied!");
                }
            }
        };
    }

    public String startSession(String username) {
        String sessionId = generateSessionId();
        sessionMap.put(sessionId, username);
        securityManager.checkPermission("access control");
        return sessionId;
    }

    public String getUsername(String sessionId) {
        return sessionMap.get(sessionId);
    }

    private String generateSessionId() {
        // Simple session id generator for demonstration
        return String.valueOf(System.currentTimeMillis());
    }
}