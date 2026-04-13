import java.util.HashMap;

public class java_18982_SessionManager_A07 {

    private HashMap<String, String> sessionMap;

    public java_18982_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        sessionMap.put(username, "active");
        System.out.println("Session started for user: " + username);
    }

    public void endSession(String username) {
        sessionMap.remove(username);
        System.out.println("Session ended for user: " + username);
    }

    public String getSessionState(String username) {
        if (sessionMap.containsKey(username)) {
            return sessionMap.get(username);
        } else {
            return "Inactive";
        }
    }

    public void checkSessionExpiry(String username) {
        if (sessionMap.get(username) != null) {
            System.out.println("Session for user: " + username + " is still active");
        } else {
            System.out.println("Session for user: " + username + " is expired");
            endSession(username);
        }
    }
}