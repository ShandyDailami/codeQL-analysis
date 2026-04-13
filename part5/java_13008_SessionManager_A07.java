import java.util.HashMap;
import java.util.Map;

public class java_13008_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_13008_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists. Please, logout before login.");
        } else {
            sessionMap.put(sessionId, userName);
            System.out.println("New session started for user: " + userName);
        }
    }

    public void endSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Session ended for user: " + userName);
        } else {
            System.out.println("No session to end.");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("A123", "John");
        sessionManager.startSession("A123", "Tom");
        sessionManager.endSession("A123");
    }
}