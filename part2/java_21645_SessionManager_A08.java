import java.util.HashMap;

public class java_21645_SessionManager_A08 {
    private HashMap<String, String> sessionMap;

    public java_21645_SessionManager_A08() {
        sessionMap = new HashMap<>();
    }

    public void startSession(String username, String password) {
        if (isPasswordSecure(password)) {
            sessionMap.put(username, password);
            System.out.println("Session started for user: " + username);
        } else {
            System.out.println("Password not secure for user: " + username);
        }
    }

    public void endSession(String username) {
        if (sessionMap.containsKey(username)) {
            sessionMap.remove(username);
            System.out.println("Session ended for user: " + username);
        } else {
            System.out.println("No session found for user: " + username);
        }
    }

    private boolean isPasswordSecure(String password) {
        // This is a placeholder for a real-world secure password check
        // In a real-world scenario, the password would likely be hashed and compared
        // to a stored hash value.
        return password.matches("[a-zA-Z0-9]+");  // Only contains alphanumeric characters
    }
}