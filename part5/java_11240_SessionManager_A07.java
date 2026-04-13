import java.util.HashMap;
import java.util.Map;

public class java_11240_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_11240_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public boolean validateUser(String username, String password) {
        String expectedPassword = userMap.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }
}