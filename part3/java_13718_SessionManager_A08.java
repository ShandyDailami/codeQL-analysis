import java.util.HashMap;
import java.util.Map;

public class java_13718_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_13718_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName, String sessionId) {
        sessionMap.put(sessionId, userName);
    }

    public String getUserName(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isSessionValid(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public void integrityFailure(String sessionId) {
        if (isSessionValid(sessionId)) {
            endSession(sessionId);
            System.out.println("IntegrityFailure detected. Ending session: " + sessionId);
        }
    }
}