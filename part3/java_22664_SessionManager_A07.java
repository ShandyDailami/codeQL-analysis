import java.util.HashMap;
import java.util.Map;

public class java_22664_SessionManager_A07 {
    // In a real application, this would likely be stored in a database or some other persistent storage.
    private static Map<String, String> userCredentials = new HashMap<>();

    static {
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public boolean authenticate(String username, String password) {
        // Simulating a long-running operation (e.g., database query, API call)
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Simulating a successful authentication
        if (userCredentials.get(username).equals(password)) {
            return true;
        }

        // Simulating a failed authentication
        return false;
    }
}