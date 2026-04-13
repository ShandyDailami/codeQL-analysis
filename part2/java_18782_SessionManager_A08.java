import java.util.HashMap;
import java.util.Map;

public class java_18782_SessionManager_A08 {
    private Map<String, String> userMap;

    public java_18782_SessionManager_A08() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public boolean isValidUser(String username, String password) {
        if (userMap.containsKey(username)) {
            return userMap.get(username).equals(password);
        }
        return false;
    }
}