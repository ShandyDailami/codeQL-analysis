import java.util.Base64;

public class java_09206_CredentialValidator_A03 {

    public boolean validate(String user, String password) {
        // Check if user and password are empty
        if (user == null || password == null || user.trim().isEmpty() || password.trim().isEmpty()) {
            return false;
        }

        // Check if user is not username
        if (user.equals("admin")) {
            return false;
        }

        // Check if password is not strong enough
        if (!password.equals(new String(Base64.getDecoder().decode(password)))) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test with valid credentials
        System.out.println(validator.validate("admin", "password"));

        // Test with invalid credentials
        System.out.println(validator.validate("admin", ""));
        System.out.println(validator.validate("", "password"));
        System.out.println(validator.validate("invalid", "invalid"));
    }
}