import java.util.HashMap;

public class java_19384_SessionManager_A01 {
    private HashMap<String, String> sessionMap;
    private HashMap<String, String> userMap;

    public java_19384_SessionManager_A01() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public void login(String username, String password) {
        if (!userMap.containsKey(username) || !userMap.get(username).equals(password)) {
            throw new RuntimeException("Invalid username or password");
        }
        sessionMap.put(username, "Session for " + username);
    }

    public String getSession(String username) {
        if (!sessionMap.containsKey(username)) {
            throw new RuntimeException("Invalid session for " + username);
        }
        return sessionMap.get(username);
    }

    public void logout(String username) {
        if (!sessionMap.containsKey(username)) {
            throw new RuntimeException("Invalid session for " + username);
        }
        sessionMap.remove(username);
    }
}