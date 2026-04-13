import java.util.HashMap;
import java.util.Map;

public class java_36192_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_36192_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String sessionID) {
        if (sessionMap.containsKey(username)) {
            System.out.println("Session for user " + username + " already exists.");
        } else {
            sessionMap.put(username, sessionID);
            System.out.println("Session started for user " + username);
        }
    }

    public void endSession(String username) {
        if (sessionMap.containsKey(username)) {
            sessionMap.remove(username);
            System.out.println("Session ended for user " + username);
        } else {
            System.out.println("No session found for user " + username);
        }
    }

    public String getSessionID(String username) {
        return sessionMap.get(username);
    }
}