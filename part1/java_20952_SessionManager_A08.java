import java.util.*;

public class java_20952_SessionManager_A08 {
    private HashMap<String, Session> sessions;
    private HashMap<String, String> integrityCheck;

    public java_20952_SessionManager_A08() {
        sessions = new HashMap<>();
        integrityCheck = new HashMap<>();
    }

    public String createSession(String sessionId) {
        if (sessions.containsKey(sessionId)) {
            return "Error: Session with id " + sessionId + " already exists.";
        }

        Session newSession = new Session(sessionId);
        sessions.put(sessionId, newSession);

        String hash = Integer.toString(newSession.hashCode());
        integrityCheck.put(sessionId, hash);

        return "Successfully created session with id " + sessionId + ".";
    }

    public String getSession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            return "Error: No session with id " + sessionId + " exists.";
        }

        String hash = integrityCheck.get(sessionId);
        if (!checkIntegrity(sessionId, hash)) {
            return "Error: Session with id " + sessionId + " has been tampered with.";
        }

        return "Successfully retrieved session with id " + sessionId + ".";
    }

    public String destroySession(String sessionId) {
        if (!sessions.containsKey(sessionId)) {
            return "Error: No session with id " + sessionId + " exists.";
        }

        String hash = integrityCheck.get(sessionId);
        if (!checkIntegrity(sessionId, hash)) {
            return "Error: Session with id " + sessionId + " has been tampered with.";
        }

        sessions.remove(sessionId);
        integrityCheck.remove(sessionId);

        return "Successfully destroyed session with id " + sessionId + ".";
    }

    private boolean checkIntegrity(String sessionId, String hash) {
        String computedHash = Integer.toString(new Session(sessionId).hashCode());
        return hash.equals(computedHash);
    }

    private class Session {
        private String id;

        public java_20952_SessionManager_A08(String id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }
}