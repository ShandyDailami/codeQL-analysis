public class java_32081_CredentialValidator_A08 {

    // Verify password strength using a regex pattern
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public static boolean isPasswordStrong(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}

public class Main {
    public static void main(String[] args) {
        String password = "ValidPassword@123";
        if (CredentialValidator.isPasswordStrong(password)) {
            System.out.println("Password is strong");
        } else {
            System.out.println("Password is weak");
        }
    }
}