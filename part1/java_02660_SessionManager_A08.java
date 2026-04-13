import java.util.HashMap;

public class java_02660_SessionManager_A08 {
    // A HashMap to simulate a database (it's actually a Map in java.util.Map)
    private HashMap<String, String> database;

    public java_02660_SessionManager_A08() {
        database = new HashMap<>();
    }

    // Method to simulate a login
    public boolean login(String username, String password) {
        // Here, we're just checking if the user exists in the database
        // This is a very basic example, a real-world application would use a secure hashing algorithm
        // and a more comprehensive security check
        if (database.containsKey(username) && database.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    // Simulating a secure operation
    public void performSecureOperation(String username) throws SecurityFailureException {
        // First, we need to log in as the user
        if (!login(username, "password")) {
            throw new SecurityFailureException("Login failed");
        }

        // Now, we can perform a secure operation
        // In this example, we're just throwing an exception
        throw new SecurityFailureException("Secure operation failed");
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager();
        manager.database.put("user", "password");

        // Trying to perform a secure operation as a not logged in user
        try {
            manager.performSecureOperation("not_logged_in_user");
        } catch (SecurityFailureException e) {
            System.out.println(e.getMessage());
        }

        // Trying to perform a secure operation as a logged in user
        try {
            manager.performSecureOperation("user");
        } catch (SecurityFailureException e) {
            System.out.println(e.getMessage());
        }
    }
}

class SecurityFailureException extends Exception {
    public java_02660_SessionManager_A08(String message) {
        super(message);
    }
}