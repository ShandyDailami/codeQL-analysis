import java.util.HashMap;
import java.util.Map;

public class java_06752_SessionManager_A03 {

    // Store user credentials in a HashMap
    private Map<String, String> userCredentials;

    public java_06752_SessionManager_A03() {
        userCredentials = new HashMap<>();
    }

    // Method to authenticate a user
    public boolean authenticateUser(String username, String password) {
        if(userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    // Method to add a user to the system
    public void addUser(String username, String password) {
        userCredentials.put(username, password);
    }

    // Method to check if a user is authenticated
    public boolean isUserAuthenticated(String username) {
        return userCredentials.containsKey(username);
    }

    // Method to get the password of a user
    public String getPassword(String username) {
        if(userCredentials.containsKey(username)) {
            return userCredentials.get(username);
        }
        return null;
    }

    // Example usage
    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        sessionManager.addUser("user1", "password1");
        sessionManager.addUser("user2", "password2");

        System.out.println(sessionManager.isUserAuthenticated("user1")); // true
        System.out.println(sessionManager.isUserAuthenticated("user3")); // false

        System.out.println(sessionManager.authenticateUser("user1", "password1")); // true
        System.out.println(sessionManager.authenticateUser("user3", "password3")); // false

        System.out.println(sessionManager.getPassword("user1")); // password1
        System.out.println(sessionManager.getPassword("user2")); // password2
    }
}