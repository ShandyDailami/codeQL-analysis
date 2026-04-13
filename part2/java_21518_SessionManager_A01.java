import java.util.HashMap;
import java.util.Map;

public class java_21518_SessionManager_A01 {
    private Map<String, String> userCredentials;

    public java_21518_SessionManager_A01() {
        userCredentials = new HashMap<>();
        // Add some dummy users for authentication
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean authenticate(String username, String password) {
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    public Session createSession(String username) {
        if (authenticate(username, userCredentials.get(username))) {
            return new Session(username);
        } else {
            throw new BrokenAccessControlException("Access Denied");
        }
    }

    public static class Session {
        private String username;

        public java_21518_SessionManager_A01(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    public static class BrokenAccessControlException extends RuntimeException {
        public java_21518_SessionManager_A01(String message) {
            super(message);
        }
    }
}