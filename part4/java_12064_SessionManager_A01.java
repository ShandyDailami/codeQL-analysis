import java.util.HashMap;

public class java_12064_SessionManager_A01 {
    // This is a basic HashMap used to simulate a session store.
    private HashMap<String, String> sessionMap;

    public java_12064_SessionManager_A01() {
        sessionMap = new HashMap<String, String>();
    }

    // The 'login' method simulates logging in a user.
    public String login(String username, String password) {
        // This is a very simple login check. In a real-world application,
        // you would need to compare the password hash with the stored hash.
        if (username.equals("admin") && password.equals("password")) {
            return "SUCCESS";
        } else {
            return "FAILURE";
        }
    }

    // The 'startSession' method simulates starting a new session.
    public String startSession(String username) {
        // In a real-world application, you would need to generate a unique
        // session ID for each session, and store it in the session map.
        String sessionId = "SESSION_" + username;
        sessionMap.put(sessionId, username);
        return sessionId;
    }

    // The 'endSession' method simulates ending a session.
    public String endSession(String sessionId) {
        // In a real-world application, you would need to check if the session
        // ID exists in the session map, and if so, remove it.
        if (sessionMap.containsKey(sessionId)) {
            sessionMap.remove(sessionId);
            return "SUCCESS";
        } else {
            return "FAILURE";
        }
    }

    // The 'getSessionUser' method simulates retrieving the username
    // associated with a session.
    public String getSessionUser(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return null;
        }
    }
}