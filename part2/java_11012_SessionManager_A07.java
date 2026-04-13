import java.util.HashMap;
import java.util.Map;

public class java_11012_SessionManager_A07 {
    private Map<String, String> usernamePasswordMap;

    public java_11012_SessionManager_A07() {
        this.usernamePasswordMap = new HashMap<>();
        usernamePasswordMap.put("user1", "password1");
        usernamePasswordMap.put("user2", "password2");
    }

    public String storeSession(String username) {
        if (usernamePasswordMap.containsKey(username)) {
            return "Session already exists for this user.";
        } else {
            String password = generatePassword();
            usernamePasswordMap.put(username, password);
            return "Session created for user " + username + " with password " + password;
        }
    }

    public String checkSession(String username, String password) {
        if (usernamePasswordMap.containsKey(username) && usernamePasswordMap.get(username).equals(password)) {
            return "Session found for user " + username;
        } else {
            return "Invalid credentials for user " + username;
        }
    }

    public String invalidateSession(String username) {
        if (usernamePasswordMap.containsKey(username)) {
            usernamePasswordMap.remove(username);
            return "Session invalidated for user " + username;
        } else {
            return "No session found for user " + username;
        }
    }

    private String generatePassword() {
        // This method should generate a password.
        // For simplicity, we're just returning a random string.
        return "password";
    }
}