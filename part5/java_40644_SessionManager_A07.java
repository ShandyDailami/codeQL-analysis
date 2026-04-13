import java.util.HashMap;
import java.util.Map;

public class java_40644_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_40644_SessionManager_A07() {
        userMap = new HashMap<>();
        userMap.put("admin", "password");
    }

    public String validateUser(String user, String password) {
        if(userMap.containsKey(user) && userMap.get(user).equals(password)) {
            return "Welcome, " + user + "!";
        } else {
            throw new SecurityException("Authentication failed.");
        }
    }
}