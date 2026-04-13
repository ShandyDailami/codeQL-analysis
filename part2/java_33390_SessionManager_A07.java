import java.util.HashMap;
import java.util.Map;

public class java_33390_SessionManager_A07 {

    private Map<String, String> userMap;

    public java_33390_SessionManager_A07() {
        userMap = new HashMap<>();
    }

    public void addUser(String username, String password) {
        userMap.put(username, password);
    }

    public String getPassword(String username) {
        return userMap.get(username);
    }

    public boolean authenticate(String username, String password) {
        String correctPassword = getPassword(username);
        if (correctPassword != null && correctPassword.equals(password)) {
            return true;
        } else {
            // A07_AuthFailure: Authentication failed.
            System.out.println("A07_AuthFailure: Authentication failed.");
            return false;
        }
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        sessionManager.addUser("user1", "password1");
        sessionManager.addUser("user2", "password2");

        // A07_AuthFailure: Authentication failed.
        sessionManager.authenticate("user3", "wrongpassword");

        // A07_AuthFailure: Authentication failed.
        sessionManager.authenticate("user1", "wrongpassword");

        sessionManager.authenticate("user1", "password1");
    }
}