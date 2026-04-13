public class java_13679_SessionManager_A08 {

    // A simple in-memory session storage
    private static Map<String, String> sessionMap = new HashMap<>();

    // This is where we'll check if a session is valid
    public static String validateSession(String sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        } else {
            return "Invalid Session";
        }
    }

    // This is where we'll create a new session
    public static void createSession(String sessionId) {
        sessionMap.put(sessionId, sessionId);
    }

    // This is where we'll delete a session
    public static void deleteSession(String sessionId) {
        sessionMap.remove(sessionId);
    }

    // This is the main method, which is where our program starts
    public static void main(String[] args) {
        // Create a new session
        createSession("1234");

        // Validate the session
        System.out.println(validateSession("1234")); // Should print "Valid Session"

        // Delete the session
        deleteSession("1234");

        // Validate the session again
        System.out.println(validateSession("1234")); // Should print "Invalid Session"
    }
}