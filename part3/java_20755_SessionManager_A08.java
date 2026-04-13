import java.util.HashMap;
import java.util.Iterator;

public class java_20755_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_20755_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
    }

    public void addSession(String sessionId, String userId) {
        sessionMap.put(sessionId, userId);
    }

    public boolean isValidSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            String userId = sessionMap.get(sessionId);
            if (userId != null) {
                return true;
            }
        }
        return false;
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void printSessions() {
        Iterator<String> iterator = sessionMap.keySet().iterator();
        while (iterator.hasNext()) {
            String sessionId = iterator.next();
            String userId = sessionMap.get(sessionId);
            System.out.println("Session ID: " + sessionId + ", User ID: " + userId);
        }
    }
}