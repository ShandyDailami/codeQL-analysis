import java.util.HashMap;
import java.util.Map;

public class java_05366_SessionManager_A01 {
    private Map<String, String> userMap;

    public java_05366_SessionManager_A01() {
        userMap = new HashMap<>();
    }

    public boolean validateUser(String username, String password) {
        if (userMap.containsKey(username)) {
            return userMap.get(username).equals(password);
        } else {
            return false;
        }
    }

    public void startSession(String username, String password) {
        if (validateUser(username, password)) {
            System.out.println("Welcome, " + username);
        } else {
            System.out.println("Invalid username or password");
        }
    }
}