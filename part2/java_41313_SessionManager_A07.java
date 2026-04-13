import java.util.HashMap;
import java.util.Map;

public class java_41313_SessionManager_A07 {
    private Map<String, String> userMap;

    public java_41313_SessionManager_A07() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public boolean authenticate(String user, String password) {
        String expectedPassword = userMap.get(user);
        return expectedPassword != null && expectedPassword.equals(password);
    }

    public void secureOperation(String user) {
        if (!authenticate(user, "password")) {
            throw new AuthFailureException("Authentication failed.");
        }

        // Access sensitive data
        // ...
    }

    public static void main(String[] args) {
        SecureSessionManager sessionManager = new SecureSessionManager();

        try {
            sessionManager.secureOperation("user1");
        } catch (AuthFailureException e) {
            e.printStackTrace();
        }

        try {
            sessionManager.secureOperation("user3");
        } catch (AuthFailureException e) {
            e.printStackTrace();
        }
    }
}