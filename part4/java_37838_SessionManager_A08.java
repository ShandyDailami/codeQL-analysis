import java.util.HashMap;
import java.util.Map;

public class java_37838_SessionManager_A08 {
    private Map<String, String> userMap;

    public java_37838_SessionManager_A08() {
        userMap = new HashMap<>();
    }

    public void createSession(String username) {
        userMap.put(username, "session");
    }

    public void login(String username) {
        if (userMap.containsKey(username)) {
            System.out.println("Logged in successfully");
        } else {
            System.out.println("Invalid username or password");
        }
    }

    public void checkSession(String username) {
        if (userMap.containsKey(username)) {
            System.out.println("Session is valid");
        } else {
            System.out.println("Session is invalid");
        }
    }

    public void logout(String username) {
        if (userMap.containsKey(username)) {
            userMap.remove(username);
            System.out.println("Logged out successfully");
        } else {
            System.out.println("User is not logged in");
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.createSession("user1");
        sessionManager.login("user1");
        sessionManager.checkSession("user1");
        sessionManager.logout("user1");
    }
}