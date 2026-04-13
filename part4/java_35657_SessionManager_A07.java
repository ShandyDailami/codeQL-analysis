import java.util.HashMap;
import java.util.Map;

public class java_35657_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_35657_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String sessionKey) {
        if (sessionMap.containsKey(sessionKey)) {
            System.out.println("Error: Session key already exists.");
            return null;
        } else {
            sessionMap.put(sessionKey, "Active");
            return sessionKey;
        }
    }

    public void closeSession(String sessionKey) {
        if (sessionMap.containsKey(sessionKey)) {
            sessionMap.remove(sessionKey);
            System.out.println("Session " + sessionKey + " closed.");
        } else {
            System.out.println("Error: Session key does not exist.");
        }
    }
}