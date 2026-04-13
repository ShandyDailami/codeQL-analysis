public class java_35019_CredentialValidator_A08 {
    private static final String ADMIN_USERNAME = "admin";
    private static final String PATTERN = "^admin$";

    public boolean isCredentialValid(String username, String password) {
        if (matchesPattern(username) && isPasswordLongEnough(password)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean matchesPattern(String username) {
        return username.matches(PATTERN);
    }

    private boolean isPasswordLongEnough(String password) {
        return password.length() >= 8;
    }
}