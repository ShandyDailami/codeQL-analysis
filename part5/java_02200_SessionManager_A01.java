import java.util.HashMap;
import java.util.Map;

public class java_02200_SessionManager_A01 {
    private Map<String, String> sessionMap;
    private boolean authenticationIncluded;

    public java_02200_SessionManager_A01() {
        sessionMap = new HashMap<>();
        authenticationIncluded = false;
    }

    public void setAuthenticationIncluded(boolean authenticationIncluded) {
        this.authenticationIncluded = authenticationIncluded;
    }

    public void startSession(String sessionId) {
        if (authenticationIncluded) {
            sessionMap.put(sessionId, sessionId);
        } else {
            // If no authentication, clear the session map
            sessionMap.clear();
        }
    }

    public void endSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }
}