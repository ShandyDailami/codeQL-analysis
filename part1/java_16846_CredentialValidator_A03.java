public class java_16846_CredentialValidator_A03 {
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        // Check if password matches strong password pattern
        return password.matches(STRONG_PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        String password = "StrongPassword123";

        if (isPasswordStrong(password)) {
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is not strong");
        }
    }
}