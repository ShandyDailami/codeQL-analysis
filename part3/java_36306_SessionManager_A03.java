import java.util.HashMap;

public class java_36306_SessionManager_A03 {

    private HashMap<String, String> sessionMap;

    public java_36306_SessionManager_A03() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public String getUserIdBySessionId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }
}

public class Main {
    public static void main(String[] args) {
        SecuritySessionManager sessionManager = new SecuritySessionManager();

        String sessionId = "123";
        String userId = "user123";

        sessionManager.createSession(sessionId, userId);

        String userFromSession = sessionManager.getUserIdBySessionId(sessionId);

        if (userFromSession.equals(userId)) {
            System.out.println("Session is valid.");
        } else {
            System.out.println("Session is invalid.");
        }

        sessionManager.removeSession(sessionId);

        userFromSession = sessionManager.getUserIdBySessionId(sessionId);

        if (userFromSession == null) {
            System.out.println("Session has been removed.");
        } else {
            System.out.println("Session is still valid.");
        }
    }
}