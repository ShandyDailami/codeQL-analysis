import java.util.HashMap;

public class java_09393_SessionManager_A01 {
    private HashMap<String, String> sessions;

    public java_09393_SessionManager_A01() {
        sessions = new HashMap<>();
    }

    public void login(String username, String password) {
        // This is a basic password check for demonstration purposes.
        // In a real-world application, you'd want to use a more secure method.
        if (password.equals("correctPassword")) {
            sessions.put(username, password);
            System.out.println("Logged in as: " + username);
        } else {
            System.out.println("Failed to log in.");
        }
    }

    public void logout(String username) {
        if (sessions.containsKey(username)) {
            sessions.remove(username);
            System.out.println("Logged out: " + username);
        } else {
            System.out.println("User not logged in.");
        }
    }

    public void performAction(String username, String action) {
        if (sessions.containsKey(username)) {
            System.out.println("Performing action: " + action);
            // Here, we're demonstrating the concept of security-sensitive operations.
            // In a real-world application, you'd want to implement a more secure method.
            if (action.equals("delete")) {
                sessions.remove(username);
            }
        } else {
            System.out.println("User not logged in.");
        }
    }
}