import java.util.HashMap;
import java.util.Map;

public class java_25864_SessionManager_A07 {
    private Map<String, String> sessionMap;

    public java_25864_SessionManager_A07() {
        this.sessionMap = new HashMap<>();
    }

    public void createSession(String username, String password) {
        if (isValidUser(username, password)) {
            sessionMap.put(username, "validSession");
            System.out.println("Session created for user: " + username);
        } else {
            System.out.println("Invalid credentials. Cannot create session.");
        }
    }

    public String getSession(String username) {
        if (sessionMap.containsKey(username) && sessionMap.get(username).equals("validSession")) {
            return "Session valid for user: " + username;
        } else {
            return "Session invalid or not found for user: " + username;
        }
    }

    private boolean isValidUser(String username, String password) {
        // For now, just validate if the password is "secure". In a real-world scenario, you'd want to hash and salt the password
        return password.equals("secure");
    }
}