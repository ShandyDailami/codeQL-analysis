import java.util.Base64;

public class java_27201_CredentialValidator_A01 {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public void validate(String username, String password) {
        if (!username.equals(VALID_USERNAME) || !isPasswordValid(password)) {
            throw new CredentialException("Invalid username or password");
        }
    }

    private boolean isPasswordValid(String password) {
        // For simplicity, we'll just check if the password is "password"
        return password.equals(VALID_PASSWORD);
    }

    public static class CredentialException extends RuntimeException {
        public java_27201_CredentialValidator_A01(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        SecureCredentialValidator validator = new SecureCredentialValidator();
        try {
            validator.validate("admin", "password");
            System.out.println("Validated successfully");
        } catch (CredentialException e) {
            System.err.println(e.getMessage());
        }
    }
}