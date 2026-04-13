import java.util.HashMap;
import java.util.Map;

public class java_17623_SessionManager_A01 {

    private Map<String, String> userMap;

    public java_17623_SessionManager_A01() {
        userMap = new HashMap<>();
        userMap.put("user1", "ROLE_USER");
        userMap.put("user2", "ROLE_ADMIN");
    }

    public String getRole(String username) {
        if (userMap.containsKey(username)) {
            return userMap.get(username);
        } else {
            throw new SecurityException("Access denied for user: " + username);
        }
    }

}