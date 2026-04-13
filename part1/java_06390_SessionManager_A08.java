import java.security.Security;
import java.util.HashMap;
import java.util.Map;

public class java_06390_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private SecurityManager securityManager;

    public java_06390_SessionManager_A08() {
        sessionMap = new HashMap<>();
        securityManager = System.getSecurityManager();
    }

    public String createSession(String sessionID) {
        if (securityManager != null) {
            securityManager.checkUserAccess(sessionID);
        }

        sessionMap.put(sessionID, sessionID);
        return sessionID;
    }

    public String getSession(String sessionID) {
        if (securityManager != null) {
            securityManager.checkUserAccess(sessionID);
        }

        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        if (securityManager != null) {
            securityManager.checkUserAccess(sessionID);
        }

        sessionMap.remove(sessionID);
    }
}