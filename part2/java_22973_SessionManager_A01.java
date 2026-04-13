import java.util.HashMap;
import java.util.Map;

public class java_22973_SessionManager_A01 {

    // Data to simulate session storage
    private Map<String, String> sessionStorage = new HashMap<>();
    private Map<String, String> userStorage = new HashMap<>();

    // Public methods for session management
    public void login(String username, String password) {
        if (userStorage.containsKey(username) && userStorage.get(username).equals(password)) {
            sessionStorage.put(username, "ValidSession");
            System.out.println("User " + username + " logged in successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void logout(String username) {
        if (sessionStorage.containsKey(username) && sessionStorage.get(username).equals("ValidSession")) {
            sessionStorage.put(username, "InvalidSession");
            System.out.println("User " + username + " logged out successfully.");
        } else {
            System.out.println("User is not logged in or session is invalid.");
        }
    }

    public void accessContent(String username) {
        if (sessionStorage.get(username).equals("ValidSession")) {
            System.out.println("Accessing content for user " + username);
        } else {
            System.out.println("User is not logged in or session is invalid.");
        }
    }
}