import java.util.HashMap;
import java.util.Map;

public class java_21929_SessionManager_A08 {
    private Map<String, String> sessionMap;

    public java_21929_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String userID, String sessionID) {
        sessionMap.put(userID, sessionID);
    }

    public String getSession(String userID) {
        if (sessionMap.containsKey(userID)) {
            return sessionMap.get(userID);
        } else {
            return null; // or throw an exception
        }
    }

    public void deleteSession(String userID) {
        sessionMap.remove(userID);
    }
}