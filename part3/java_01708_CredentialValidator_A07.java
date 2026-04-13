import java.util.HashMap;
import java.util.Map;

public class java_01708_CredentialValidator_A07 {
    private Map<String, String> validUsers;

    public java_01708_CredentialValidator_A07() {
        validUsers = new HashMap<>();
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    public void validate(String username, String password) throws AuthFailureException {
        if (!validUsers.containsKey(username) || !validUsers.get(username).equals(password)) {
            throw new AuthFailureException();
        }
    }

    public static class AuthFailureException extends Exception {
        // No specific exception here; this class is just a simple placeholder
    }
}