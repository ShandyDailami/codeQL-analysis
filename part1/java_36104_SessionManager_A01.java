import javax.management.RuntimeErrorException;
import java.util.*;

public class java_36104_SessionManager_A01 {
    private List<String> sessions = new ArrayList<>();

    // Session creation
    public String createSession(String user) {
        String sessionId = UUID.randomUUID().toString();
        sessions.add(sessionId);
        return sessionId;
    }

    // Session validation
    public boolean validateSession(String sessionId, String user) {
        return sessions.contains(sessionId);
    }

    // Session termination
    public void terminateSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        String sessionId = sm.createSession("John");
        if(sm.validateSession(sessionId, "John")) {
            sm.terminateSession(sessionId);
            System.out.println("Session terminated successfully");
        } else {
            System.out.println("Invalid session, unable to terminate");
        }
    }
}