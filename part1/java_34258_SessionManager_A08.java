// Import the necessary libraries
import java.util.HashMap;
import java.util.Map;

public class java_34258_SessionManager_A08 {
    // A HashMap to simulate a database
    private Map<String, String> database;

    // Constructor
    public java_34258_SessionManager_A08() {
        database = new HashMap<>();
    }

    // Method to create a session
    public void createSession(String sessionId, String userId) {
        // In a real-world scenario, this would involve adding the session to the database
        // For now, let's just add the sessionId and userId to the database
        database.put(sessionId, userId);
    }

    // Method to get the user for a given session
    public String getUser(String sessionId) {
        // In a real-world scenario, this would involve looking up the sessionId in the database
        // For now, let's just return the userId
        return database.get(sessionId);
    }

    // Method to close a session
    public void closeSession(String sessionId) {
        // In a real-world scenario, this would involve removing the session from the database
        // For now, let's just remove the sessionId from the database
        database.remove(sessionId);
    }
}