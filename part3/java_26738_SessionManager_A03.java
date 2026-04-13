import java.util.HashMap;
import java.util.Map;

public class java_26738_SessionManager_A03 {
    private Map<String, String> userMap;

    public java_26738_SessionManager_A03() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public String authenticate(String user, String password) {
        if (userMap.containsKey(user) && userMap.get(user).equals(password)) {
            return "Welcome, " + user;
        } else {
            return "Invalid username or password";
        }
    }
}