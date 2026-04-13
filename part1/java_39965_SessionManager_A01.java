import java.util.HashMap;
import java.util.Map;

public class java_39965_SessionManager_A01 {

    private Map<String, String> sessionMap;

    public java_39965_SessionManager_A01() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String password) {
        if (validateUser(username, password)) {
            sessionMap.put(username, password);
        } else {
            System.out.println("Invalid username or password");
        }
    }

    public void validateSession(String username) {
        if (sessionMap.containsKey(username)) {
            System.out.println("Session valid for user: " + username);
        } else {
            System.out.println("Session invalid or not found for user: " + username);
        }
    }

    private boolean validateUser(String username, String password) {
        // Here we just check if the username and password match a hardcoded one
        // In a real world scenario, a secure way of validating the user would be to compare hashed passwords
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.createSession("admin", "password");
        sessionManager.validateSession("admin");
        sessionManager.validateSession("test");
    }
}