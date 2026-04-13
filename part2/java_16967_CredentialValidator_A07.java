import java.util.regex.Pattern;

public class java_16967_CredentialValidator_A07 {

    // Define a regular expression pattern for a strong password
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])";

    // Check if a given password is strong
    public static boolean isStrongPassword(String password) {
        return Pattern.matches(STRONG_PASSWORD_PATTERN, password);
    }

    // CredentialValidator implementation
    public static class MyCredentialValidator implements CredentialValidator {
        public String authenticate(String userName, String password) throws AuthenticationException {
            // Check if password is strong
            if (!isStrongPassword(password)) {
                throw new AuthFailureException("Password is not strong enough. It should contain at least one uppercase letter, one lowercase letter, one digit, one special character, and is not null or empty.");
            }

            // If password is strong, return success
            return SuccessfulAuthenticationEvent.authenticatedIdentity(userName);
        }
    }

    // Usage
    public static void main(String[] args) {
        CredentialValidationManager cm = new CredentialValidationManager();
        cm.registerCredentialValidator(new MyCredentialValidator(), "MyCredentialValidator");
        cm.setAuthenticationHandlers(new CredentialHandler[]{new MyCredentialHandler()});
    }
}