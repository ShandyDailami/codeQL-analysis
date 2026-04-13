public class java_26843_CredentialValidator_A08 {
    // Check if password is strong enough
    private static boolean isStrongPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*-])(?=\\S+$).{8,}$");
    }

    // Check if password is not too weak
    private static boolean isNotTooWeak(String password) {
        return password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
    }

    // Validate password
    public static boolean validate(String password) {
        if (!isStrongPassword(password) && !isNotTooWeak(password)) {
            return false;
        }
        return true;
    }
}