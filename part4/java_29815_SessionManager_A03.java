import java.util.HashMap;
import java.util.Map;

public class java_29815_SessionManager_A03 {
    // We use a HashMap to simulate a database
    private Map<String, String> database;

    public java_29815_SessionManager_A03() {
        database = new HashMap<>();
    }

    // Simulate a method to login with a username and password
    public boolean login(String username, String password) {
        // For simplicity, we just check if the password is correct
        // This is not secure, but for demonstration purposes
        if (password.equals("securepassword")) {
            database.put("username", username);
            return true;
        } else {
            return false;
        }
    }

    // Simulate a method to get a user's information
    public String getUserInfo(String username) {
        // We are only retrieving information if the user is logged in
        if (database.containsKey("username") && database.get("username").equals(username)) {
            return database.get("username");
        } else {
            return null;
        }
    }

    // Simulate a method to logout a user
    public void logout(String username) {
        // We are only logging out the user if they are logged in
        if (database.containsKey("username") && database.get("username").equals(username)) {
            database.remove("username");
        }
    }
}