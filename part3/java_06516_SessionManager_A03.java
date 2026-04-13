import java.util.HashMap;

public class java_06516_SessionManager_A03 {
    private HashMap<String, Object> sessions;

    public java_06516_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public void createSession(String id, Object sessionObject) {
        sessions.put(id, sessionObject);
    }

    public Object getSession(String id) {
        return sessions.get(id);
    }

    public void updateSession(String id, Object sessionObject) {
        if (sessions.containsKey(id)) {
            sessions.put(id, sessionObject);
        }
    }

    public void deleteSession(String id) {
        sessions.remove(id);
    }
}