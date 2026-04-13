import java.util.HashMap;
import java.util.Map;

public class java_38214_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_38214_SessionManager_A01() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String userId) {
        // implement your own logic here to create a session
        // for example, you can add the userId and sessionId to the map
        sessionMap.put(sessionId, userId);
    }

    public String getUserId(String sessionId) {
        // implement your own logic here to get the userId from the session
        // for example, you can return the userId from the map
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        // implement your own logic here to delete the session
        // for example, you can remove the sessionId from the map
        sessionMap.remove(sessionId);
    }
}