import java.util.HashMap;

public class java_33067_SessionManager_A07 {

    private HashMap<String, String> sessionMap;
    private HashMap<String, String> userMap;

    public java_33067_SessionManager_A07() {
        sessionMap = new HashMap<String, String>();
        userMap = new HashMap<String, String>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public String getSession(String sessionId) {
        return sessionMap.get(sessionId);
    }

    public void addSession(String sessionId, String username) {
        sessionMap.put(sessionId, username);
    }

    public void removeSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    public boolean isValidUser(String username, String password) {
        if (userMap.containsKey(username)) {
            return userMap.get(username).equals(password);
        } else {
            return false;
        }
    }

    public boolean isValidSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return true;
        } else {
            return false;
        }
    }
}