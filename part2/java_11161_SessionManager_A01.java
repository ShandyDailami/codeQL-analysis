import java.util.HashMap;
import java.util.Map;

public class java_11161_SessionManager_A01 {
    private Map<String, String> sessionMap;

    public java_11161_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void login(String username, String password) {
        // You could use a real authentication mechanism here, but for simplicity, let's just check if the password is correct
        if ("admin".equals(username) && "password".equals(password)) {
            sessionMap.put("username", username);
            System.out.println("Logged in as " + username);
        } else {
            System.out.println("Failed to login");
        }
    }

    public void logout(String username) {
        if (sessionMap.containsKey("username") && sessionMap.get("username").equals(username)) {
            sessionMap.remove("username");
            System.out.println("Logged out from " + username);
        } else {
            System.out.println("Failed to logout. No user logged in.");
        }
    }

    public void accessResource(String resource) {
        if (sessionMap.containsKey("username")) {
            System.out.println("Accessing resource: " + resource);
        } else {
            System.out.println("Failed to access resource. No user logged in.");
        }
    }
}