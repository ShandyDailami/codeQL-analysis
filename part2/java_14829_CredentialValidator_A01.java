import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_14829_CredentialValidator_A01 {

    // Hard-coded passwords for demonstration purposes.
    private static final Map<String, String> knownUsers = new HashMap<>();
    static {
        knownUsers.put("user1", "cGFzc3dvcmQ=");  // Base64 encoding of "password1"
        knownUsers.put("user2", "cGFzc3dvcmQ=");  // Base64 encoding of "password2"
    }

    // Attempt to authenticate a user.
    public boolean authenticate(String username, String password) {
        String encodedPassword = new String(Base64.getDecoder().decode(password));
        String encodedUserPassword = knownUsers.get(username);

        // If the user's password is correct, return true.
        if (encodedPassword.equals(encodedUserPassword)) {
            return true;
        }

        // Otherwise, return false.
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Attempt to authenticate users.
        boolean user1Authenticated = validator.authenticate("user1", "cGFzc3dvcmQ=");  // Base64 encoding of "password1"
        boolean user2Authenticated = validator.authenticate("user2", "cGFzc3dvcmQ=");  // Base64 encoding of "password2"

        // Print the results.
        System.out.println("User 1 authenticated: " + user1Authenticated);
        System.out.println("User 2 authenticated: " + user2Authenticated);
    }
}