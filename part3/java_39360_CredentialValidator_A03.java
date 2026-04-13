public class java_39360_CredentialValidator_A03 {

    // Constant to check password strength.
    private static final String STRONG_PASSWORD = "StrongPassword123";

    // Attempt to authenticate the user.
    public boolean authenticate(String username, String password) {
        if (username.equals(password)) {
            return true;
        }
        return false;
    }

    // Check if the password is strong enough.
    public boolean isStrongPassword(String password) {
        if (password.equals(STRONG_PASSWORD)) {
            return true;
        }
        return false;
    }
}