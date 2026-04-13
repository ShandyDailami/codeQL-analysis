import java.util.HashMap;
import java.util.Map;

public class java_41278_SessionManager_A08 {
    private String userId;
    private long startTime;

    public java_41278_SessionManager_A08(String userId) {
        this.userId = userId;
        this.startTime = System.currentTimeMillis();
    }

    public boolean isSessionExpired() {
        long currentTime = System.currentTimeMillis();
        long sessionTime = this.startTime + (10 * 60 * 1000); // 10 minutes
        return currentTime > sessionTime;
    }

    public String getUserId() {
        return userId;
    }
}

public class SessionManager {
    private Map<String, UserSession> sessions = new HashMap<>();

    public void startSession(String userId) {
        if (sessions.containsKey(userId)) {
            sessions.get(userId).startTime = System.currentTimeMillis();
        } else {
            sessions.put(userId, new UserSession(userId));
        }
    }

    public void checkSession(String userId) {
        if (sessions.containsKey(userId)) {
            UserSession session = sessions.get(userId);
            if (session.isSessionExpired()) {
                System.out.println("Session expired for user: " + session.getUserId());
                sessions.remove(userId);
            } else {
                System.out.println("Session is valid for user: " + session.getUserId());
            }
        } else {
            System.out.println("No session found for user: " + userId);
        }
    }
}