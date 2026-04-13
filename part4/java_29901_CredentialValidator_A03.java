import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_29901_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_29901_CredentialValidator_A03() {
        // Hardcoded credentials for simplicity
        this.credentials = new HashMap<>();
        this.credentials.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        this.credentials.put("user1", Base64.getEncoder().encodeToString("user1:user1".getBytes()));
    }

    public boolean validate(String username, String password) {
        // Decoding the password from Base64
        String decodedPassword = new String(Base64.getDecoder().decode(this.credentials.get(username)));

        // Checking if the passwords match
        return decodedPassword.equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Testing the system
        boolean isValid = validator.validate("admin", "admin");
        System.out.println("Is valid: " + isValid); // Should print: Is valid: true

        isValid = validator.validate("user1", "user1");
        System.out.println("Is valid: " + isValid); // Should print: Is valid: true

        isValid = validator.validate("admin", "wrongpassword");
        System.out.println("Is valid: " + isValid); // Should print: Is valid: false

        isValid = validator.validate("unknownuser", "password");
        System.out.println("Is valid: " + isValid); // Should print: Is valid: false
    }
}