import java.util.HashMap;

public class java_09543_SessionManager_A07 {
    private HashMap<String, String> sessionMap;
    private HashMap<String, String> passwordMap;

    public java_09543_SessionManager_A07() {
        sessionMap = new HashMap<>();
        passwordMap = new HashMap<>();
    }

    public void startSession(String user, String password) throws AuthFailure {
        if (passwordMap.containsKey(user)) {
            throw new AuthFailure("User already logged in");
        }
        String sessionId = Integer.toString(sessionMap.size() + 1);
        sessionMap.put(sessionId, user);
        passwordMap.put(user, password);
    }

    public String getUser(String sessionId) throws AuthFailure {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailure("Invalid session");
        }
        return sessionMap.get(sessionId);
    }

    public void endSession(String sessionId) throws AuthFailure {
        if (!sessionMap.containsKey(sessionId)) {
            throw new AuthFailure("Invalid session");
        }
        String user = sessionMap.get(sessionId);
        sessionMap.remove(sessionId);
        passwordMap.remove(user);
    }

    public boolean isValidUser(String user, String password) throws AuthFailure {
        if (!passwordMap.containsKey(user)) {
            throw new AuthFailure("Invalid user");
        }
        return passwordMap.get(user).equals(password);
    }
}