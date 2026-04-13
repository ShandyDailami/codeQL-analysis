import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_36933_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_36933_CredentialValidator_A03() {
        // Hardcoded credentials for simplicity
        this.credentials = new HashMap<String, String>() {
            {
                put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
                put("user", Base64.getEncoder().encodeToString("userpassword".getBytes()));
            }
        };
    }

    public boolean validate(String username, String password) {
        // Check if the password matches the encoded password
        if (credentials.containsKey(username) &&
            credentials.get(username).equals(Base64.getEncoder().encodeToString(password.getBytes()))) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate admin
        boolean isAdminValid = validator.validate("admin", "password");
        System.out.println("Is admin valid? " + (isAdminValid ? "Yes" : "No"));

        // Validate user
        boolean isUserValid = validator.validate("user", "userpassword");
        System.out.println("Is user valid? " + (isUserValid ? "Yes" : "No"));

        // Invalid credentials
        boolean isInvalidValid = validator.validate("admin", "invalidpassword");
        System.out.println("Is invalid valid? " + (isInvalidValid ? "Yes" : "No"));
    }
}