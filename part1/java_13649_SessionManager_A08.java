import java.util.HashMap;

public class java_13649_SessionManager_A08 {
    private HashMap<String, String> sessions;

    public java_13649_SessionManager_A08() {
        sessions = new HashMap<>();
    }

    public void startSession(String userId) {
        // For simplicity, let's assume that the user Id is stored in plain text in the session.
        // In reality, this would require hashing the userId and adding it to the session.
        sessions.put(userId, userId);
    }

    public String getSession(String userId) {
        // Check if the userId is valid. In a real application, this would require a database lookup.
        // In this case, we're just returning a hardcoded check.
        if (userId.equals("validUser")) {
            return "validUser";
        }
        return null;
    }

    public void endSession(String userId) {
        // In a real application, the session would be closed here.
        // In this example, we're just removing the session from the hashmap.
        sessions.remove(userId);
    }
}