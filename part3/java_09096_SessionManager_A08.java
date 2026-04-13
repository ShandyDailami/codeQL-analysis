import java.util.HashMap;
import java.util.Map;

public class java_09096_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_09096_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userID) {
        String sessionID = userID + System.currentTimeMillis();
        sessionMap.put(sessionID, userID);
        System.out.println("Started session for user: " + userID + " with ID: " + sessionID);
    }

    public void endSession(String sessionID) {
        String userID = sessionMap.get(sessionID);
        sessionMap.remove(sessionID);
        System.out.println("Ended session for user: " + userID + " with ID: " + sessionID);
    }

    public String getUserIDFromSession(String sessionID) {
        return sessionMap.get(sessionID);
    }

    public static void main(String[] args) {
        SecuritySessionManager sessionManager = new SecuritySessionManager();

        sessionManager.startSession("User1");
        sessionManager.startSession("User2");
        sessionManager.startSession("User3");

        sessionManager.endSession("User2");
        sessionManager.endSession("User1");

        System.out.println("User " + sessionManager.getUserIDFromSession("User1") + " is still logged in");
        System.out.println("User " + sessionManager.getUserIDFromSession("User3") + " is still logged in");
    }
}