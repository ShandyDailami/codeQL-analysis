import java.util.HashMap;
import java.util.Map;

public class java_23908_SessionManager_A08 {
    private Map<String, String> users;

    public java_23908_SessionManager_A08() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public String login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return "Welcome, " + username + ". You are now logged in.";
        } else {
            return "Invalid username or password.";
        }
    }
}