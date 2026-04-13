import java.util.HashMap;
import java.util.Map;

public class java_00283_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_00283_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        sessionMap.put(userName, "Active");
        System.out.println("Session started for user: " + userName);
    }

    public void endSession(String userName) {
        if(sessionMap.containsKey(userName)) {
            sessionMap.remove(userName);
            System.out.println("Session ended for user: " + userName);
        } else {
            System.out.println("User: " + userName + " has no active session.");
        }
    }

    public String checkSession(String userName) {
        if(sessionMap.containsKey(userName)) {
            return "User: " + userName + " has an active session.";
        } else {
            return "User: " + userName + " has no active session.";
        }
    }
}