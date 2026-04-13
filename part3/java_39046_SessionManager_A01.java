import java.util.HashMap;

public class java_39046_SessionManager_A01 {
    private HashMap<String, String> sessionMap;

    public java_39046_SessionManager_A01() {
        sessionMap = new HashMap<String, String>();
    }

    public void startSession(String userId) {
        sessionMap.put(userId, "Active");
        System.out.println("Session started for user: " + userId);
    }

    public void endSession(String userId) {
        if (sessionMap.get(userId) != null) {
            sessionMap.put(userId, "Inactive");
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("User: " + userId + " has no active session.");
        }
    }

    public String getSessionStatus(String userId) {
        return sessionMap.get(userId);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession("User1");
        sessionManager.endSession("User1");
        System.out.println("User1's session status: " + sessionManager.getSessionStatus("User1"));
        sessionManager.startSession("User2");
        System.out.println("User2's session status: " + sessionManager.getSessionStatus("User2"));
        sessionManager.endSession("User2");
    }
}