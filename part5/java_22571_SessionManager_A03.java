import java.util.HashSet;
import java.util.Set;

public class java_22571_SessionManager_A03 {

    private static final Set<String> SESSION_IDS = new HashSet<>();

    public static void startSession(String sessionId) {
        if (SESSION_IDS.contains(sessionId)) {
            throw new IllegalStateException("Session already started with ID: " + sessionId);
        }
        SESSION_IDS.add(sessionId);
        // perform any security-sensitive operations here...
    }

    public static void endSession(String sessionId) {
        if (!SESSION_IDS.contains(sessionId)) {
            throw new IllegalStateException("Session not started with ID: " + sessionId);
       
        }
        SESSION_IDS.remove(sessionId);
        // perform any security-sensitive operations here...
    }
}