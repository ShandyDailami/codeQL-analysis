public class java_24744_CredentialValidator_A07 {

    private static final String WEAK_PASSWORD = "Weak password";
    private static final String STRONG_PASSWORD = "Strong password";
    private static final String UNSAFE_PASSWORD = "Unsafe password";

    public String validatePassword(String password) {
        if (password == null || password.length() == 0) {
            return UNSAFE_PASSWORD;
        }

        if (password.matches(".*\\d.*")) {
            return WEAK_PASSWORD;
        }

        if (password.matches(".*[a-z].*")) {
            return UNSAFE_PASSWORD;
        }

        if (password.matches(".*[A-Z].*")) {
            return STRONG_PASSWORD;
        }

        return STRONG_PASSWORD;
    }
}