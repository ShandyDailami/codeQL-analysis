import java.util.HashMap;
import java.util.Map;

public class java_40241_SessionManager_A08 {
    private Map<String, String> userMap;

    public java_40241_SessionManager_A08() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public boolean isValidUser(String username, String password) {
        String storedPassword = userMap.get(username);
        if (storedPassword == null) {
            return false;
        }
        return storedPassword.equals(password);
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.addUser("admin", "password");

        // Checking user authentication
        if (manager.isValidUser("admin", "password")) {
            System.out.println("User is authenticated successfully!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}