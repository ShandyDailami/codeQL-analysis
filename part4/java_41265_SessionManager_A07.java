import java.util.HashMap;
import java.util.Map;

public class java_41265_SessionManager_A07 {
    private Map<String, String> userPasswords;

    public java_41265_SessionManager_A07() {
        userPasswords = new HashMap<>();
        userPasswords.put("admin", "password");
    }

    public boolean isValidUser(String username, String password) {
        return userPasswords.containsKey(username) && userPasswords.get(username).equals(password);
    }

    public void authenticate(String username, String password) throws AuthFailureException {
        if (!isValidUser(username, password)) {
            throw new AuthFailureException("Authentication failure");
        }
    }
}

public class AuthFailureException extends Exception {
    public java_41265_SessionManager_A07(String message) {
        super(message);
    }
}