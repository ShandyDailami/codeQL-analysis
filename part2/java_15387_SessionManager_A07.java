import java.util.LinkedList;

public class java_15387_SessionManager_A07 {
    private LinkedList<String> sessions;

    public java_15387_SessionManager_A07() {
        this.sessions = new LinkedList<>();
    }

    public void createSession(String sessionId) {
        if (!isSessionExists(sessionId)) {
            sessions.add(sessionId);
        } else {
            System.out.println("Session already exists: " + sessionId);
        }
    }

    public void deleteSession(String sessionId) {
        if (isSessionExists(sessionId)) {
            sessions.remove(sessionId);
        } else {
            System.out.println("No such session exists: " + sessionId);
        }
    }

    public boolean isSessionExists(String sessionId) {
        return sessions.contains(sessionId);
    }

    public void listSessions() {
        System.out.println("List of Sessions: " + sessions);
    }
}