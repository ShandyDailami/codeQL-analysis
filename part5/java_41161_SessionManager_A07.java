import java.util.HashMap;
import java.util.UUID;

public class java_41161_SessionManager_A07 {

    private HashMap<UUID, String> sessionMap;

    public java_41161_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public UUID createSession(String sessionData) {
        UUID sessionId = UUID.randomUUID();
        sessionMap.put(sessionId, sessionData);
        return sessionId;
    }

    public String getSessionData(UUID sessionId) {
        String sessionData = sessionMap.get(sessionId);
        if (sessionData == null) {
            System.out.println("No session data found for session ID: " + sessionId);
        }
        return sessionData;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        UUID sessionId = sessionManager.createSession("Session data from main method");
        System.out.println("Session ID: " + sessionId);

        String sessionData = sessionManager.getSessionData(sessionId);
        if (sessionData != null) {
            System.out.println("Session data: " + sessionData);
        }
    }
}