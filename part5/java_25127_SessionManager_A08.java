import java.util.HashMap;
import java.util.Map;

public class java_25127_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_25127_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        // Generate a session ID
        String sessionID = userName + System.currentTimeMillis();
        sessionMap.put(sessionID, userName);
        System.out.println("Started session for user " + userName + " with ID " + sessionID);
    }

    public String getUserName(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void endSession(String sessionID) {
        String userName = sessionMap.get(sessionID);
        if (userName != null) {
            sessionMap.remove(sessionID);
            System.out.println("Ended session for user " + userName + " with ID " + sessionID);
        } else {
            System.out.println("Invalid session ID");
        }
    }
}