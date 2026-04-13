public class java_14226_CredentialValidator_A03 {

    // The minimum password strength in characters
    private static final int MIN_PASSWORD_LENGTH = 10;

    // The maximum password strength in characters
    private static final int MAX_PASSWORD_LENGTH = 20;

    // The maximum times a password can be re-entered
    private static final int MAX_PASSWORD_ATTEMPTS = 3;

    private int passwordAttempts;

    public java_14226_CredentialValidator_A03() {
        this.passwordAttempts = 0;
    }

    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        if (passwordAttempts >= MAX_PASSWORD_ATTEMPTS) {
            return false;
        }

        // Assume the password is strong enough if it passes all the following checks
        return true;
    }

    public void resetPasswordAttempts() {
        this.passwordAttempts = 0;
    }

    public void incrementPasswordAttempts() {
        this.passwordAttempts++;
    }
}