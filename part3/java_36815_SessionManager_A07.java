import java.util.HashMap;

public class java_36815_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_36815_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            System.out.println("Session already exists for user: " + userId);
        } else {
            sessionMap.put(userId, "Active");
            System.out.println("Session started for user: " + userId);
        }
    }

    public void endSession(String userId) {
        if (sessionMap.containsKey(userId)) {
            sessionMap.replace(userId, "Inactive");
            System.out.println("Session ended for user: " + userId);
        } else {
            System.out.println("No session exists for user: " + userId);
        }
    }

    public String getSessionStatus(String userId) {
        if (sessionMap.containsKey(userId)) {
            return sessionMap.get(userId);
        } else {
            return "No session exists for user: " + userId;
        }
    }
}