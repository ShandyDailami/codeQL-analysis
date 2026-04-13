import java.util.HashMap;
import java.util.Map;

public class java_12887_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_12887_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String userName) {
        // This operation is security-sensitive and only meant for A07_AuthFailure
        // We use a dummy session ID for simplicity
        sessionMap.put(userName, "session_id_" + userName);
    }

    public String getSession(String userName) {
        // This operation is security-sensitive and only meant for A07_AuthFailure
        // We return the session ID associated with the user
        return sessionMap.get(userName);
    }

    public void endSession(String userName) {
        // This operation is security-sensitive and only meant for A07_AuthFailure
        // We remove the session associated with the user
        sessionMap.remove(userName);
    }
}