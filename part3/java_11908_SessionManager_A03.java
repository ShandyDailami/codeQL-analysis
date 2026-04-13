import java.util.HashMap;
import java.util.Map;

public class java_11908_SessionManager_A03 {
    private Map<String, String> sessionMap;

    public java_11908_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId) {
        sessionMap.put(sessionId, "Active");
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public String getSessionStatus(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void setSessionId(String sessionId, String newSessionId) {
        sessionMap.put(newSessionId, "Active");
        sessionMap.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.startSession("Session1");
        sessionManager.startSession("Session2");
        sessionManager.startSession("Session3");

        System.out.println(sessionManager.getSessionStatus("Session1")); // Active
        System.out.println(sessionManager.getSessionStatus("Session2")); // Active
        System.out.println(sessionManager.getSessionStatus("Session3")); // Active

        sessionManager.setSessionId("Session1", "NewSession");

        System.out.println(sessionManager.getSessionStatus("NewSession")); // Active
    }
}