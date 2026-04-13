import java.util.HashMap;
import java.util.Map;

public class java_36165_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_36165_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String userName, String password) {
        this.credentials.put(userName, password);
    }

    public boolean validateCredentials(String userName, String password) {
        if (this.credentials.containsKey(userName)) {
            return this.credentials.get(userName).equals(password);
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addCredential("user1", "password1");
        validator.addCredential("user2", "password2");

        boolean isValid = validator.validateCredentials("user1", "password1");
        System.out.println("Is valid: " + isValid); // Outputs: Is valid: true

        isValid = validator.validateCredentials("user1", "wrongPassword");
        System.out.println("Is valid: " + isValid); // Outputs: Is valid: false

        isValid = validator.validateCredentials("unknownUser", "password");
        System.out.println("Is valid: " + isValid); // Outputs: Is valid: false
    }
}