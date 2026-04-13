public class java_05529_CredentialValidator_A03 {

    // The pattern the password must match
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean isValid(String password) {
        // Check if password is null
        if (password == null) {
            return false;
        }

        // Check if password matches the pattern
        if (!password.matches(PASSWORD_PATTERN)) {
            return false;
        }

        return true;
    }
}