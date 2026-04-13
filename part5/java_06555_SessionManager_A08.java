import java.util.*;

public class java_06555_SessionManager_A08 {

    private Map<String, String> userSessions;

    public java_06555_SessionManager_A08() {
        userSessions = new HashMap<>();
    }

    public void login(String username, String password) {
        // Simulate security-sensitive operation to hash the password
        String hashedPassword = hashPassword(password);
        userSessions.put(username, hashedPassword);
    }

    public boolean isValidSession(String username, String password) {
        // Simulate security-sensitive operation to verify the password
        String hashedPassword = userSessions.get(username);
        return hashedPassword.equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        // Simulate security-sensitive operation to hash the password
        // This is a simplistic example, in a real-world scenario you should use a stronger hashing algorithm
        return password;
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.login("user1", "password1");
        boolean isValid = manager.isValidSession("user1", "password1");
        System.out.println("Is valid session? " + isValid);
    }
}