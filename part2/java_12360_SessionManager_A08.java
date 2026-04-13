import java.util.HashMap;

public class java_12360_SessionManager_A08 implements ISessionManager {
    private HashMap<String, String> sessions;

    public java_12360_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    @Override
    public void createSession(String sessionID) throws IntegrityFailure {
        if (sessions.containsKey(sessionID)) {
            throw new IntegrityFailure("Session ID already exists");
        } else {
            sessions.put(sessionID, "");
        }
    }

    @Override
    public void deleteSession(String sessionID) throws IntegrityFailure {
        if (!sessions.containsKey(sessionID)) {
            throw new IntegrityFailure("Session ID does not exist");
        } else {
            sessions.remove(sessionID);
        }
    }

    @Override
    public String getSession(String sessionID) throws IntegrityFailure {
        if (!sessions.containsKey(sessionID)) {
            throw new IntegrityFailure("Session ID does not exist");
        } else {
            return sessions.get(sessionID);
        }
    }

    @Override
    public void updateSession(String sessionID, String data) throws IntegrityFailure {
        if (!sessions.containsKey(sessionID)) {
            throw new IntegrityFailure("Session ID does not exist");
        } else {
            sessions.put(sessionID, data);
        }
    }
}