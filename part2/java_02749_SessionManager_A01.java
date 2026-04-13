import java.util.HashMap;
import java.util.Map;

public class java_02749_SessionManager_A01 {
    private Map<String, String> database;

    public java_02749_SessionManager_A01() {
        database = new HashMap<>();
    }

    public boolean login(String username, String password) {
        if (isValid(username, password)) {
            database.put(username, password);
            return true;
        }
        return false;
    }

    public boolean logout(String username) {
        if (database.containsKey(username)) {
            database.remove(username);
            return true;
        }
        return false;
    }

    private boolean isValid(String username, String password) {
        // This is a placeholder for a secure password check.
        // In a real application, you should use a secure method to verify the password.
        return true;
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();

        // Test login
        manager.login("user1", "password1");
        System.out.println(manager.database);

        // Test logout
        manager.logout("user1");
        System.out.println(manager.database);
    }
}