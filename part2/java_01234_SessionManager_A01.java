import java.util.*;

public class java_01234_SessionManager_A01 {

    // This is a static hashmap to simulate a database.
    private static HashMap<String, String> database = new HashMap<>();

    // This is a static hashmap to simulate a session table.
    private static HashMap<String, String> sessionTable = new HashMap<>();

    // This is a method to simulate a login action.
    public static void login(String username, String password) {
        // Checking the database for the username and password.
        if (database.containsKey(username) && database.get(username).equals(password)) {
            // If the username and password are correct, create a new session.
            String sessionId = UUID.randomUUID().toString();
            sessionTable.put(sessionId, username);
            System.out.println("Session created: " + sessionId);
        } else {
            // If the username or password is incorrect, print an error message.
            System.out.println("Invalid username or password");
        }
    }

    // This is a method to simulate a logout action.
    public static void logout(String sessionId) {
        // Checking the session table for the sessionId.
        if (sessionTable.containsKey(sessionId)) {
            // If the sessionId is valid, remove the session from the session table.
            String username = sessionTable.get(sessionId);
            sessionTable.remove(sessionId);
            System.out.println("Session logged out: " + username);
        } else {
            // If the sessionId is not valid, print an error message.
            System.out.println("Invalid session id");
        }
    }

    // This is a method to simulate a read action.
    public static void read(String sessionId) {
        // Checking the session table for the sessionId.
        if (sessionTable.containsKey(sessionId)) {
            // If the sessionId is valid, print the username associated with the session.
            String username = sessionTable.get(sessionId);
            System.out.println("Session: " + username);
        } else {
            // If the sessionId is not valid, print an error message.
            System.out.println("Invalid session id");
        }
    }
}