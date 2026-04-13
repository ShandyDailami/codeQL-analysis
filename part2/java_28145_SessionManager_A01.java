import java.util.HashMap;
import java.util.Map;

public class java_28145_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_28145_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionData) {
        sessionMap.put(sessionId, sessionData);
    }

    public String getSessionData(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionActive(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void updateSession(String sessionId, String newData) {
        if (isSessionActive(sessionId)) {
            sessionMap.replace(sessionId, newData);
        } else {
            System.out.println("Session not active. Cannot update session.");
        }
    }

    public void sessionSecurityCheck(String sessionId) {
        if (!isSessionActive(sessionId)) {
            System.out.println("Access Denied: Session is not active.");
            return;
        }

        String sessionData = getSessionData(sessionId);

        if (sessionData.equals("sensitiveInformation")) {
            System.out.println("Access Denied: Sensitive information found in session.");
            return;
        }

        System.out.println("Session Access Granted: Session data is undetected.");
    }
}