import java.util.HashMap;
import java.util.Map;

public class java_16437_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_16437_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public String validateUser(String username, String password) {
        String expectedPassword = userMap.get(username);
        if (expectedPassword != null && expectedPassword.equals(password)) {
            return "Welcome, " + username + "!";
        } else {
            return "Invalid credentials.";
        }
    }
}