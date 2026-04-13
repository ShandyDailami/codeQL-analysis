import java.util.HashMap;
import java.util.Map;

public class java_27989_SessionManager_A07 {
    private Map<String, String> expectedCredentials;

    public java_27989_SessionManager_A07() {
        expectedCredentials = new HashMap<>();
        expectedCredentials.put("user1", "password1");
        expectedCredentials.put("user2", "password2");
    }

    public void checkCredentials(String username, String password) throws AuthFailureException {
        if (!expectedCredentials.containsKey(username) || !expectedCredentials.get(username).equals(password)) {
            throw new AuthFailureException();
        }
    }

    public static void main(String[] args) {
        AuthFailureSessionManager sessionManager = new AuthFailureSessionManager();

        try {
            sessionManager.checkCredentials("user1", "password1"); // Correct credentials
            sessionManager.checkCredentials("user3", "wrongpassword"); // Incorrect credentials
        } catch (AuthFailureException e) {
            System.out.println("Authentication failed. Please try again.");
        }
    }
}

class AuthFailureException extends Exception {
    public java_27989_SessionManager_A07() {
        super("Authentication failed. Please try again.");
    }
}