import java.util.HashMap;
import java.util.Map;

public class java_09277_SessionManager_A01 {
    private Map<String, String> userMap;
    private Map<String, String> passwordMap;

    public java_09277_SessionManager_A01() {
        userMap = new HashMap<>();
        passwordMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
        passwordMap.put(password, username);
    }

    public boolean login(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return true;
        } else if (passwordMap.containsKey(password) && passwordMap.get(password).equals(username)) {
            return true;
        } else {
            return false;
        }
    }

    public void createSession(String username) {
        if (login(username, userMap.get(username))) {
            System.out.println("Session created for user: " + username);
        } else {
            System.out.println("Failed to create session");
        }
    }

    public void destroySession(String username) {
        if (login(username, userMap.get(username))) {
            System.out.println("Session destroyed for user: " + username);
        } else {
            System.out.println("Failed to destroy session");
        }
    }
}