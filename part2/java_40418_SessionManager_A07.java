import java.util.HashMap;
import java.util.Map;

public class java_40418_SessionManager_A07 {

    // Create a private instance of HashMap
    private Map<String, String> sessionMap;

    public java_40418_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    // Create a method to create a session
    public String createSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            System.out.println("Session already exists");
            return null;
        }
        sessionMap.put(sessionId, sessionId);
        return sessionId;
    }

    // Create a method to get a session
    public String getSession(String sessionId) {
        if(!sessionMap.containsKey(sessionId)) {
            System.out.println("Session does not exist");
            return null;
        }
        return sessionMap.get(sessionId);
    }

    // Create a method to destroy a session
    public void destroySession(String sessionId) {
        if(!sessionMap.containsKey(sessionId)) {
            System.out.println("Session does not exist");
            return;
        }
        sessionMap.remove(sessionId);
        System.out.println("Session destroyed");
    }
}