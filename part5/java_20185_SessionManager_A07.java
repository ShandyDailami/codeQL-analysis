import java.util.HashMap;

public class java_20185_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_20185_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userID) {
        String sessionID = userID + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);
        return sessionID;
    }

    public String getUserID(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public void destroySession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        String sessionID = manager.createSession("user1");
        System.out.println("Session ID: " + sessionID);
        String userID = manager.getUserID(sessionID);
        System.out.println("User ID: " + userID);
        manager.destroySession(sessionID);
    }
}