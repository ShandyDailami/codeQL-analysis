import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class java_02287_SessionManager_A08 {
    // UserData is a simple class to hold user data
    public class UserData {
        public String userName;
        public Date loginTime;

        public java_02287_SessionManager_A08(String userName) {
            this.userName = userName;
            this.loginTime = new Date();
        }
    }

    private Map<String, UserData> activeSessions;

    public java_02287_SessionManager_A08() {
        activeSessions = new HashMap<>();
    }

    // Method to create a new session
    public String createSession(String userName) {
        if (!checkUserName(userName)) {
            throw new SecurityException("Invalid username!");
        }

        String sessionId = String.valueOf(System.currentTimeMillis());
        activeSessions.put(sessionId, new UserData(userName));
        return sessionId;
    }

    // Method to check if a session is active
    public boolean isSessionActive(String sessionId) {
        return activeSessions.containsKey(sessionId);
    }

    // Method to check if a user is still logged in
    public boolean isUserStillLoggedIn(String sessionId, String userName) {
        if (!isSessionActive(sessionId)) {
            throw new SecurityException("Session not active!");
        }

        UserData userData = activeSessions.get(sessionId);
        return userData.userName.equals(userName) && !userData.loginTime.after(new Date(System.currentTimeMillis() - 5 * 60 * 1000)); // Check if the user is still logged in for 5 minutes
    }

    // Method to check if a username is valid
    private boolean checkUserName(String userName) {
        // This would be a method to check the userName against a database or another source of truth.
        // For this example, we'll just check if the userName is not null or empty.
        return userName != null && !userName.trim().isEmpty();
    }
}