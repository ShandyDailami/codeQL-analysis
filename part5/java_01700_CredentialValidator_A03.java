import java.util.HashMap;
import java.util.Map;

public class java_01700_CredentialValidator_A03 {

    private Map<String, String> userPasswords;

    public java_01700_CredentialValidator_A03() {
        userPasswords = new HashMap<>();
        // Add sample user/passwords
        userPasswords.put("user1", "password1");
        userPasswords.put("user2", "password2");
        userPasswords.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        // Check if the password matches the stored password for the given username
        if (userPasswords.containsKey(username) && userPasswords.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean valid = validator.validateCredentials("user1", "password1");
        if (valid) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied for user1");
        }

        valid = validator.validateCredentials("user4", "password4");
        if (valid) {
            System.out.println("Access granted for user4");
        } else {
            System.out.println("Access denied for user4");
        }
    }
}