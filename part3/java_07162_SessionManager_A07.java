import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class java_07162_SessionManager_A07 {
    private Map<String, Object> sessionMap;

    public java_07162_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId) {
        sessionMap.put(sessionId, new Date());
    }

    public void addItemToSession(String sessionId, String itemId) {
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, itemId);
        } else {
            System.out.println("Invalid session id: " + sessionId);
        }
    }

    public Object getItemFromSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            Date creationTime = (Date) sessionMap.get(sessionId);
            long currentTime = new Date().getTime();
            long timeSinceCreation = (currentTime - creationTime.getTime()) / 1000;

            if (timeSinceCreation < 300) { // 5 minutes
                return sessionMap.get(sessionId);
            } else {
                System.out.println("Session expired: " + sessionId);
                sessionMap.remove(sessionId);
            }
        } else {
            System.out.println("Invalid session id: " + sessionId);
        }

        return null;
    }
}