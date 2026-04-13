import java.util.HashMap;
import java.util.Map;

public class java_04725_SessionManager_A08 {
    // A simple in-memory store of logged in users
    private Map<String, String> loggedUsers = new HashMap<>();
    // A simple in-memory store of passwords
    private Map<String, String> passwords = new HashMap<>();

    // This method is used for logging in a user
    public void login(String username, String password) {
        if (passwordMatches(username, password)) {
            loggedUsers.put(username, password);
            System.out.println("User has successfully logged in");
        } else {
            System.out.println("Invalid username or password");
        }
    }

    // This method is used for logging out a user
    public void logout(String username) {
        if (loggedUsers.containsKey(username)) {
            loggedUsers.remove(username);
            System.out.println("User has successfully logged out");
        } else {
            System.out.println("User is not logged in");
        }
    }

    // This method checks if the password for a given username matches the stored password
    private boolean passwordMatches(String username, String password) {
        if (!passwords.containsKey(username)) {
            System.out.println("User " + username + " does not exist, password cannot be verified");
            return false;
        }
        return passwords.get(username).equals(password);
    }
}