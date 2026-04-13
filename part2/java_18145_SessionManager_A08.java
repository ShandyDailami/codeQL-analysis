import java.util.HashMap;
import java.util.Map;

public class java_18145_SessionManager_A08 {
    private Map<String, String> sessionMap;
    private Map<String, String> passwordMap;

    public java_18145_SessionManager_A08() {
        this.sessionMap = new HashMap<>();
        this.passwordMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (sessionMap.containsKey(username)) {
            System.out.println("Session already started for user: " + username);
        } else {
            sessionMap.put(username, password);
            passwordMap.put(username, password);
            System.out.println("Session started for user: " + username);
        }
    }

    public void validateSession(String username, String password) {
        if (sessionMap.containsKey(username) && passwordMap.containsKey(username) && passwordMap.get(username).equals(password)) {
            System.out.println("Session is valid for user: " + username);
        } else {
            System.out.println("Session is invalid for user: " + username);
            if (sessionMap.containsKey(username)) {
                System.out.println("Session has not been closed yet. Closing session for user: " + username);
                closeSession(username);
            }
        }
    }

    public void closeSession(String username) {
        if (sessionMap.containsKey(username)) {
            sessionMap.remove(username);
            passwordMap.remove(username);
            System.out.println("Session closed for user: " + username);
        } else {
            System.out.println("No session exists for user: " + username);
        }
    }
}