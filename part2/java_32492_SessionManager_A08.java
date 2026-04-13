import java.util.HashMap;
import java.util.Map;

public class java_32492_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_32492_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        if (sessionMap.containsKey(sessionId)) {
            System.out.println("Error: Session with ID " + sessionId + " already exists.");
        } else {
            sessionMap.put(sessionId, userName);
            System.out.println("Started session with ID " + sessionId + " for user " + userName);
        }
    }

    public void endSession(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: No session with ID " + sessionId + " exists.");
        } else {
            String userName = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Ended session with ID " + sessionId + " for user " + userName);
        }
    }

    public String getUserName(String sessionId) {
        if (!sessionMap.containsKey(sessionId)) {
            System.out.println("Error: No session with ID " + sessionId + " exists.");
            return null;
        } else {
            return sessionMap.get(sessionId);
        }
    }
}