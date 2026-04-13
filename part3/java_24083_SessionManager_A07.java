import java.util.HashMap;
import java.util.Map;

public class java_24083_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_24083_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        sessionMap.put(sessionId, userId);
        return sessionId;
    }

    public String getUserId(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidSession(String sessionId) {
        return sessionMap.containsKey(sessionId);
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();

        String userId = "user1";
        String sessionId = sm.createSession(userId);
        System.out.println("Created session: " + sessionId);

        String user2Id = sm.createSession("user2");
        System.out.println("Created session: " + user2Id);

        String user2Session = sm.getUserId(user2Id);
        System.out.println("User from session: " + user2Session);

        sm.deleteSession(sessionId);
        System.out.println("Deleted session: " + sessionId);

        boolean isValid = sm.isValidSession(sessionId);
        System.out.println("Is valid session: " + isValid);
    }
}