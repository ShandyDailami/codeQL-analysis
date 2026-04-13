import java.util.HashMap;
import java.util.Map;

public class java_32072_SessionManager_A08 {
    private Map<String, UserSession> sessionMap;

    public java_32072_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void authenticateUser(String username, String password) {
        // Simulate authentication by checking if username and password match
        if (username.equals("admin") && password.equals("password")) {
            UserSession session = new UserSession();
            session.setUsername(username);
            sessionMap.put(username, session);
            System.out.println("User authenticated successfully!");
        } else {
            System.out.println("Authentication failed!");
        }
    }

    public UserSession getSession(String username) {
        return sessionMap.get(username);
    }

    public void logout(String username) {
        sessionMap.remove(username);
        System.out.println("User logged out!");
    }

    private class UserSession {
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}