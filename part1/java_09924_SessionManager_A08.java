import java.util.HashMap;
import java.util.Map;

public class java_09924_SessionManager_A08 {
    private Map<String, String> userPasswords;

    public java_09924_SessionManager_A08() {
        this.userPasswords = new HashMap<>();
        // Fill userPasswords with some dummy data
        userPasswords.put("user1", "password1");
        userPasswords.put("user2", "password2");
        userPasswords.put("user3", "password3");
    }

    public boolean isValidPassword(String user, String password) {
        // Simulate a password check
        // This could be a call to a database or another security mechanism
        return userPasswords.containsKey(user) && userPasswords.get(user).equals(password);
    }

    public void logPasswordCompromise(String user) {
        // Simulate logging a compromised password
        // This could be a call to a log file or another security mechanism
        System.out.println("Password for user " + user + " has been compromised!");
    }
}