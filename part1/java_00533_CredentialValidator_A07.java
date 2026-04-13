import java.util.HashMap;
import java.util.Map;

public class java_00533_CredentialValidator_A07 {
    private Map<String, String> users;

    public java_00533_CredentialValidator_A07() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        return users.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean valid = validator.validateCredentials("user1", "password1");
        if (valid) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }

        valid = validator.validateCredentials("user4", "password4");
        if (valid) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}