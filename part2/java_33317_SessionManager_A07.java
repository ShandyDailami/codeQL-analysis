import java.util.HashMap;
import java.util.Map;

public class java_33317_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_33317_SessionManager_A07() {
        sessionMap = new HashMap<>();
    }

    public void createSession(String username, String password) {
        if (isValidUser(username, password)) {
            sessionMap.put(username, password);
            System.out.println("Session created for user: " + username);
        } else {
            System.out.println("Invalid credentials for user: " + username);
        }
    }

    public void getSession(String username) {
        String password = sessionMap.get(username);
        if (password != null) {
            System.out.println("Session for user: " + username + " is valid. Password: " + password);
        } else {
            System.out.println("No session found for user: " + username);
        }
    }

    private boolean isValidUser(String username, String password) {
        // Here, you could implement the logic to check the username and password against a database
        // or another external source of authentication information.
        // For the sake of this example, we'll just return true if the username and password match.
        return username.equals("admin") && password.equals("password");
    }
}