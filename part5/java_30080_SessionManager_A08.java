import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class java_30080_SessionManager_A08 {
    private List<String> sessions;

    public java_30080_SessionManager_A08() {
        sessions = new LinkedList<>();
    }

    public void createSession(String sessionId) {
        if (sessions.contains(sessionId)) {
            System.out.println("Session with id " + sessionId + " already exists.");
        } else {
            sessions.add(sessionId);
            System.out.println("Session with id " + sessionId + " created.");
        }
    }

    public void deleteSession(String sessionId) {
        if (sessions.contains(sessionId)) {
            sessions.remove(sessionId);
            System.out.println("Session with id " + sessionId + " deleted.");
        } else {
            System.out.println("Session with id " + sessionId + " does not exist.");
        }
    }

    public void checkIntegrity() {
        if (sessions.isEmpty()) {
            System.out.println("No sessions.");
        } else {
            System.out.println("Session integrity check failed. Sessions: " + sessions);
        }
    }
}