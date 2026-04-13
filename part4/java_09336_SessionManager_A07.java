import java.util.HashMap;
import java.util.Map;

public class java_09336_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_09336_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public String getUserPassword(String userName) {
        return userMap.get(userName);
    }

    public void addUser(String userName, String password) {
        userMap.put(userName, password);
    }

    public boolean authenticateUser(String userName, String password) {
        String correctPassword = userMap.get(userName);
        return correctPassword != null && correctPassword.equals(password);
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.addUser("user1", "password1");
        sessionManager.addUser("user2", "password2");

        if (sessionManager.authenticateUser("user1", "wrongPassword")) {
            System.out.println("Authentication failed for user1");
        } else if (sessionManager.authenticateUser("user1", "password1")) {
            System.out.println("Authentication succeeded for user1");
        }

        if (sessionManager.authenticateUser("user2", "wrongPassword")) {
            System.out.println("Authentication failed for user2");
        } else if (sessionManager.authenticateUser("user2", "password2")) {
            System.out.println("Authentication succeeded for user2");
        }
    }
}