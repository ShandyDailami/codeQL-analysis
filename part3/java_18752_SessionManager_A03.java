import java.util.HashMap;
import java.util.Map;

public class java_18752_SessionManager_A03 {
    // A simple way to store user data
    private Map<String, String> userMap;

    public java_18752_SessionManager_A03() {
        userMap = new HashMap<>();
    }

    // Method to authenticate a user
    public boolean authenticate(String userName, String password) {
        // This is a weak password for simplicity. In real application, we should use hashing and salt.
        if ("admin".equals(userName) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Method to store user data in session
    public void storeUserData(String userName, String userData) {
        if (authenticate(userName, "password")) {
            userMap.put(userName, userData);
        }
    }

    // Method to retrieve user data from session
    public String retrieveUserData(String userName) {
        if (authenticate(userName, "password")) {
            return userMap.get(userName);
        } else {
            return null; // Return null if authentication failed
        }
    }
}