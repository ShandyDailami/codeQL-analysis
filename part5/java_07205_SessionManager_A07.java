import java.util.HashMap;

public class java_07205_SessionManager_A07 {
    private HashMap<String, String> sessionMap;
    private HashMap<String, String> userMap;

    public java_07205_SessionManager_A07() {
        sessionMap = new HashMap<>();
        userMap = new HashMap<>();
    }

    // method to login a user
    public void login(String username, String password) {
        // check if the user exists in the database
        if (userMap.containsKey(username)) {
            // check if the password matches the hashed password in the database
            if (userMap.get(username).equals(password)) {
                // if both checks pass, generate a session ID and store it in the session map
                String sessionId = generateSessionId();
                sessionMap.put(sessionId, username);
                System.out.println("Logged in as user: " + username);
            } else {
                System.out.println("Invalid password for user: " + username);
            }
        } else {
            System.out.println("User does not exist: " + username);
        }
    }

    // method to logout a user
    public void logout(String sessionId) {
        // if the session ID exists in the session map, remove it from the session map
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            sessionMap.remove(sessionId);
            System.out.println("Logged out as user: " + username);
        } else {
            System.out.println("Invalid session ID: " + sessionId);
        }
    }

    // method to check if a user is logged in
    public void isLoggedIn(String sessionId) {
        // if the session ID exists in the session map, print that the user is logged in
        if (sessionMap.containsKey(sessionId)) {
            String username = sessionMap.get(sessionId);
            System.out.println("User: " + username + " is logged in.");
        } else {
            System.out.println("No user is logged in.");
        }
    }

    // method to generate a session ID
    private String generateSessionId() {
        // in a real-world application, this would likely be a more complex process
        // for simplicity, we'll just use a random string as a session ID
        return "sessionId";
    }
}