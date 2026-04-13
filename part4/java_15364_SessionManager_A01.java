import java.util.HashMap;
import java.util.Map;

public class java_15364_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_15364_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        if (sessionMap.containsKey(userName)) {
            System.out.println("Session already started for user: " + userName);
        } else {
            sessionMap.put(userName, "Started");
            System.out.println("Session started for user: " + userName);
        }
    }

    public void endSession(String userName) {
        if (sessionMap.containsKey(userName)) {
            sessionMap.put(userName, "Ended");
            System.out.println("Session ended for user: " + userName);
        } else {
            System.out.println("No session started for user: " + userName);
        }
    }

    public String getSessionStatus(String userName) {
        if (sessionMap.containsKey(userName)) {
            return sessionMap.get(userName);
        } else {
            return "No session started for user: " + userName;
        }
    }
}