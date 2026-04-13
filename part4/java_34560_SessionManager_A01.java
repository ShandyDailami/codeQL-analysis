import java.util.HashMap;
import java.util.Map;

public class java_34560_SessionManager_A01 {
    private Map<String, Session> sessions;
    private String[] allowedIds;

    public java_34560_SessionManager_A01(String[] allowedIds) {
        this.sessions = new HashMap<>();
        this.allowedIds = allowedIds;
    }

    public Session getSession(String id) {
        if (isAllowed(id)) {
            return sessions.get(id);
        } else {
            throw new IllegalArgumentException("Access to session " + id + " is not allowed");
        }
    }

    public void setSession(String id, Session session) {
        if (isAllowed(id)) {
            sessions.put(id, session);
        } else {
            throw new IllegalArgumentException("Access to session " + id + " is not allowed");
        }
    }

    private boolean isAllowed(String id) {
        for (String allowedId : allowedIds) {
            if (allowedId.equals(id)) {
                return true;
            }
        }
        return false;
    }
}