import java.util.HashMap;
import java.util.Map;

public class java_17522_SessionManager_A08 {
    private Map<String, String> userDatabase;

    public java_17522_SessionManager_A08() {
        userDatabase = new HashMap<>();
        userDatabase.put("alice", "password123");
        userDatabase.put("bob", "password456");
    }

    public String login(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            return "Welcome, " + username + "! You are now logged in.";
        } else {
            return "Login failed. Please try again.";
        }
    }
}