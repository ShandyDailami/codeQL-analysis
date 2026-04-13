import java.util.HashMap;
import java.util.Map;

public class java_04372_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_04372_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void checkAuthFailure(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            if (!sessionMap.get(sessionId).equals("expectedSessionId")) {
                deleteSession(sessionId);
                System.out.println("Auth failure detected for session: " + sessionId);
            }
        } else {
            System.out.println("Session not found: " + sessionId);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        String sessionId1 = sessionManager.createSession("session1");
        String sessionId2 = sessionManager.createSession("session2");

        sessionManager.checkAuthFailure(sessionId1);
        sessionManager.checkAuthFailure("nonExistentSession");

        sessionManager.getSession("session1"); // Expected to return "session1"
    }
}