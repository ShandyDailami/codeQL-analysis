import java.security.InvalidParameterException;

public class java_38672_CredentialValidator_A07 {

    public static final String USER_NAME_PREFIX = "A07_";

    public boolean validateCredentials(String userName, String password) {
        // Check if username is in the correct format
        if (!userName.startsWith(USER_NAME_PREFIX)
                || userName.length() < USER_NAME_PREFIX.length() + 3
                || !userName.endsWith("_AuthFailure")) {
            throw new InvalidParameterException("Invalid username format. Expected 'A07_AuthFailure'");
        }

        // Check if password contains a common password or weak password
        if (containsCommonPassword(password) || containsWeakPassword(password)) {
            throw new InvalidParameterException("Password is weak or contains common passwords");
        }

        // All checks passed, return true
        return true;
    }

    private boolean containsCommonPassword(String password) {
        // This is a simple list of common passwords, you might want to use a more secure way
        // to check if a password is contained in this list.
        String[] commonPasswords = {"123456", "password", "admin", "qwerty"};
        for (String passwords : commonPasswords) {
            if (password.toLowerCase().contains(passwords.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    private boolean containsWeakPassword(String password) {
        // This is a simple way to check if a password is weak. A real-world application would
        // use more sophisticated methods to check a password's strength.
        if (password.length() < 8) {
            return true;
        }
        return false;
    }
}