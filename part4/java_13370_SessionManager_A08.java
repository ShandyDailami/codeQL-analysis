import java.util.HashMap;
import java.util.Map;

public class java_13370_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private boolean integrityCheckFailed;

    public java_13370_SessionManager_A08() {
        sessionMap = new HashMap<>();
        integrityCheckFailed = false;
    }

    public String getSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            if (integrityCheckFailed) {
                System.out.println("Integrity check failed. A session has been requested that the system does not contain.");
                return null;
            }
            System.out.println("No session found with id: " + sessionId);
            return null;
        }
        return sessionMap.get(sessionId);
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public void checkIntegrity() {
        integrityCheckFailed = true;
    }
}