import java.util.HashMap;

public class java_31882_SessionManager_A08 {
    // Define a HashMap to simulate a database
    private HashMap<String, String> database;

    // Define a HashMap to simulate a session manager
    private HashMap<String, String> sessionManager;

    // Define a static idCounter for session creation
    private static int idCounter = 0;

    // Define a constructor
    public java_31882_SessionManager_A08() {
        // Initialize the database
        database = new HashMap<>();

        // Initialize the session manager
        sessionManager = new HashMap<>();
    }

    // Method to log in a user
    public String login(String username, String password) {
        // Check if the user is in the database
        if (database.containsKey(username) && database.get(username).equals(password)) {
            // If the user is in the database, create a session
            String sessionId = createSession();

            // Store the session id in the session manager
            sessionManager.put(sessionId, username);

            // Return the session id
            return sessionId;
        } else {
            // If the user is not in the database or the password is incorrect, return null
            return null;
        }
    }

    // Method to log out a user
    public String logout(String sessionId) {
        // Check if the session id is in the session manager
        if (sessionManager.containsKey(sessionId)) {
            // If the session id is in the session manager, get the username
            String username = sessionManager.get(sessionId);

            // Remove the session id from the session manager
            sessionManager.remove(sessionId);

            // Return the username
            return username;
        } else {
            // If the session id is not in the session manager, return null
            return null;
        }
    }

    // Method to create a session
    private String createSession() {
        // Increase the idCounter and return it
        return String.valueOf(idCounter++);
    }
}