import java.util.HashMap;
import java.util.Map;

public class java_21693_SessionManager_A03 {
    private Map<String, String> users;

    public java_21693_SessionManager_A03() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public String createSession(String username, String password) {
        if (isValid(username, password)) {
            String sessionId = String.valueOf(System.currentTimeMillis());
            users.put(username, sessionId);
            return sessionId;
        }
        return null;
    }

    public void validateSession(String sessionId) {
        for (Map.Entry<String, String> entry : users.entrySet()) {
            if (entry.getValue().equals(sessionId)) {
                System.out.println("Session validated for user: " + entry.getKey());
                return;
            }
        }
        System.out.println("Invalid session: " + sessionId);
    }

    private boolean isValid(String username, String password) {
        return username != null && password != null && username.equals("user1") && password.equals("password1");
    }
}