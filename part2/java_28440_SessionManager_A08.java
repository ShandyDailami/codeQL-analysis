import java.util.HashMap;

public class java_28440_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_28440_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String sessionId, String sessionValue) {
        sessionMap.put(sessionId, sessionValue);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public void updateSession(String sessionId, String sessionValue) {
        if(sessionMap.containsKey(sessionId)) {
            sessionMap.put(sessionId, sessionValue);
        } else {
            System.out.println("Session not found");
        }
    }

    public String getSession(String sessionId) {
        if(sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }

    public void integrityCheck() {
        for(String sessionId : sessionMap.keySet()) {
            if(!sessionMap.get(sessionId).equals(sessionMap.get(sessionId))) {
                System.out.println("IntegrityFailure detected in sessionId: " + sessionId);
                deleteSession(sessionId);
            }
        }
    }
}