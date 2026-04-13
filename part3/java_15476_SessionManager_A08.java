import java.util.HashMap;
import java.util.Map;

public class java_15476_SessionManager_A08 {
    // User details map. This is a very basic approach and should not be used in a real-world application.
    private Map<String, String> userMap = new HashMap<>();

    // This is just a placeholder for how you'd create the user map.
    public java_15476_SessionManager_A08() {
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public boolean login(String username, String password) {
        if (userMap.containsKey(username) && userMap.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}