import java.util.*;

public class java_27417_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_27417_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = UUID.randomUUID().toString();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserFromSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    public void updateSession(String sessionID, String userID) {
        if(sessionMap.containsKey(sessionID)) {
            sessionMap.put(sessionID, userID);
        } else {
            System.out.println("Invalid session ID");
        }
    }

    public boolean isValidSession(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }
}