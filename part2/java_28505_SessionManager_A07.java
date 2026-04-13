import java.util.HashMap;
import java.util.Map;

public class java_28505_SessionManager_A07 {
    private Map<String, String> userDatabase;

    public java_28505_SessionManager_A07() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    public String authenticate(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            return "Welcome, " + username + "! Your session has been started.";
        } else {
            return "Sorry, invalid credentials.";
        }
    }

    public String startSession(String username) {
        if (userDatabase.containsKey(username)) {
            return "Session started for " + username;
        } else {
            return "User " + username + " does not exist.";
        }
    }

    public String endSession(String username) {
        if (userDatabase.containsKey(username)) {
            return "Session ended for " + username;
        } else {
            return "User " + username + " does not exist.";
        }
    }
}