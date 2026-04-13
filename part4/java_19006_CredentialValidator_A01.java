import java.util.HashMap;
import java.util.Map;

public class java_19006_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_19006_CredentialValidator_A01() {
        // Create a HashMap to store the credentials
        credentials = new HashMap<>();
        // Add some default credentials
        credentials.put("user1", "pass1");
        credentials.put("user2", "pass2");
    }

    public boolean validate(String username, String password) {
        // If the username and password match the stored credentials, return true
        return credentials.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        boolean valid = validator.validate("user1", "pass1");
        System.out.println("Is valid? " + valid);

        valid = validator.validate("user2", "pass2");
        System.out.println("Is valid? " + valid);

        valid = validator.validate("wrongUser", "wrongPass");
        System.out.println("Is valid? " + valid);
    }
}