import java.util.HashMap;
import java.util.Map;

public class java_17325_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_17325_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public boolean authenticate(String username, String password) {
        if (userMap.containsKey(username)) {
            // Check password here with hashed password if necessary
            if (userMap.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void createSession(String username) {
        userMap.put(username, "password");  // In a real-world application, password should be hashed and not stored in plain text
    }

    public boolean hasSession(String username) {
        return userMap.containsKey(username);
    }

    public void endSession(String username) {
        userMap.remove(username);
    }
}