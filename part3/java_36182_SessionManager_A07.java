import java.util.HashMap;
import java.util.Map;

public class java_36182_SessionManager_A07 {
    private static Map<String, String> userDatabase = new HashMap<>();

    static {
        userDatabase.put("admin", "password");
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        try {
            String username = args[0];
            String password = args[1];

            // Attempt login
            if (authenticate(username, password)) {
                sessionManager.startSession();
                System.out.println("Welcome, " + username);
                sessionManager.stopSession();
            } else {
                System.out.println("Failed to authenticate");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String username, String password) {
        return userDatabase.get(username).equals(password);
    }
}

class SessionManager {
    private boolean sessionActive = false;

    public void startSession() {
        if (!sessionActive) {
            System.out.println("Starting session");
            sessionActive = true;
        }
    }

    public void stopSession() {
        if (sessionActive) {
            System.out.println("Stopping session");
            sessionActive = false;
        }
    }
}