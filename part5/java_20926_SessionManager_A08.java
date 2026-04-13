import java.util.HashMap;
import java.util.Map;

public class java_20926_SessionManager_A08 {

    private Map<String, String> sessionMap;

    public java_20926_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username) {
        if (sessionMap.containsKey(username)) {
            throw new SecurityException("Session already exists for user " + username);
        }
        sessionMap.put(username, "Session active");
    }

    public void endSession(String username) {
        if (!sessionMap.containsKey(username)) {
            throw new SecurityException("No session found for user " + username);
        }
        sessionMap.remove(username);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.startSession("user1");
        sm.endSession("user1");
    }

}