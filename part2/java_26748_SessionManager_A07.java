import java.util.HashMap;
import java.util.Map;

public class java_26748_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_26748_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String sessionId, String userName) {
        if(sessionMap.containsKey(sessionId)) {
            System.out.println("Session " + sessionId + " already exists");
            return;
        }

        sessionMap.put(sessionId, userName);
        System.out.println("Session " + sessionId + " started for user " + userName);
    }

    public void endSession(String sessionId) {
        if(!sessionMap.containsKey(sessionId)) {
            System.out.println("No session " + sessionId + " exists");
            return;
        }

        String userName = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        System.out.println("Session " + sessionId + " ended for user " + userName);
    }

    public String getUserName(String sessionId) {
        if(!sessionMap.containsKey(sessionId)) {
            System.out.println("No session " + sessionId + " exists");
            return null;
        }

        return sessionMap.get(sessionId);
    }
}