import java.util.HashMap;
import java.util.Map;

public class java_09873_SessionManager_A03 {
    private Map<String, UserSession> sessions;

    public java_09873_SessionManager_A03() {
        sessions = new HashMap<>();
    }

    public UserSession createSession(String userId) {
        UserSession userSession = new UserSession(userId);
        sessions.put(userId, userSession);
        return userSession;
    }

    public UserSession getSession(String userId) {
        return sessions.get(userId);
    }

    public void deleteSession(String userId) {
        sessions.remove(userId);
    }

    public void secureOperation(String userId, String operation) {
        UserSession session = getSession(userId);
        if (session != null) {
            if ("read".equals(operation)) {
                // Security: Only a known user can read the data.
                session.read();
            } else if ("write".equals(operation)) {
                // Security: Only a known user can write the data.
                session.write();
            } else {
                throw new IllegalArgumentException("Unknown operation: " + operation);
            }
        } else {
            throw new IllegalArgumentException("No session found for user: " + userId);
        }
    }
}

class UserSession {
    private String userId;

    public java_09873_SessionManager_A03(String userId) {
        this.userId = userId;
    }

    public void read() {
        // Implementation of read operation
        System.out.println("Reading data for user: " + userId);
    }

    public void write() {
        // Implementation of write operation
        System.out.println("Writing data for user: " + userId);
    }
}