import java.util.HashMap;

public class java_10182_SessionManager_A07 {
    private HashMap<String, String> sessionMap;

    public java_10182_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public String login(String username, String password) {
        // Hard-coded user list
        if (!(username.equals("user1") && password.equals("password1")) &&
            !(username.equals("user2") && password.equals("password2"))) {
            return "Invalid credentials";
        }

        // Generate a session ID
        String sessionID = String.valueOf(System.currentTimeMillis());
        sessionMap.put(sessionID, username);

        return sessionID;
    }

    public String getSession(String sessionID) {
        if (sessionMap.containsKey(sessionID)) {
            return sessionMap.get(sessionID);
        }

        return null;
    }

    public void logout(String sessionID) {
        sessionMap.remove(sessionID);
    }
}