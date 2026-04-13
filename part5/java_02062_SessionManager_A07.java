import java.util.HashMap;
import java.util.Map;

public class java_02062_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_02062_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        sessionMap.put(userName, "SessionActive");
        System.out.println("Session started for user: " + userName);
    }

    public void endSession(String userName) {
        if(sessionMap.containsKey(userName)) {
            sessionMap.remove(userName);
            System.out.println("Session ended for user: " + userName);
        } else {
            System.out.println("No session found for user: " + userName);
        }
    }

    public String getSessionStatus(String userName) {
        if(sessionMap.containsKey(userName)) {
            return "Session active";
        } else {
            return "No session found";
        }
    }
}