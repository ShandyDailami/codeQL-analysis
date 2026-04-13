import java.util.HashMap;

public class java_12873_SessionManager_A07 {
    private HashMap<String, Boolean> sessionMap;

    public java_12873_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void openSession(String sessionId) {
        sessionMap.put(sessionId, true);
        System.out.println("Session " + sessionId + " opened");
    }

    public void closeSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, false);
            System.out.println("Session " + sessionId + " closed");
        } else {
            System.out.println("No such session found");
        }
    }

    public boolean isSessionOpen(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            System.out.println("No such session found");
            return false;
        }
    }
}