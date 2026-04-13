import java.util.HashMap;
import java.util.Map;

public class java_41602_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_41602_SessionManager_A01() {
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

    public void deleteSession(String sessionID) {
        sessionMap.remove(sessionID);
    }

    public boolean isValidSession(String sessionID) {
        return sessionMap.containsKey(sessionID);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        String userID = "user1";
        String sessionID = manager.createSession(userID);

        System.out.println("Session ID: " + sessionID);
        System.out.println("User ID: " + manager.getUserID(sessionID));

        manager.deleteSession(sessionID);
        System.out.println("Is Valid Session: " + manager.isValidSession(sessionID));
    }
}