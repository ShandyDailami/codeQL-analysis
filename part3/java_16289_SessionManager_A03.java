import java.util.ArrayList;
import java.util.List;

public class java_16289_SessionManager_A03 {
    // List of users
    private List<String> users = new ArrayList<>();

    // Method to add user to session
    public void addUser(String username) {
        users.add(username);
    }

    // Method to access user's data
    public void accessUserData(String username) {
        // Check if user exists in session
        if (users.contains(username)) {
            // Access user's data...
            System.out.println("Accessing data for user: " + username);
        } else {
            System.out.println("User: " + username + " does not exist in session.");
        }
    }

    // Method to end user's session
    public void endUserSession(String username) {
        // Check if user exists in session
        if (users.contains(username)) {
            users.remove(username);
            System.out.println("Session ended for user: " + username);
        } else {
            System.out.println("User: " + username + " does not exist in session.");
        }
    }

    // Method to print all active users
    public void printActiveUsers() {
        System.out.println("Active users in session:");
        for (String user : users) {
            System.out.println(user);
        }
    }
}