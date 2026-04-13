public class java_09598_CredentialValidator_A08 {

    // A static password length
    private static final int MIN_PASSWORD_LENGTH = 8;

    // A strong password must contain at least one uppercase letter, one lowercase letter, one number and one special character
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*])[a-zA-Z0-9!@#\$\%\^&\*]{" + MIN_PASSWORD_LENGTH + ",}$";

    private java_09598_CredentialValidator_A08() {
        // prevent instantiation
    }

    public static boolean isPasswordStrong(String password) {
        return password.matches(STRONG_PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        System.out.println(isPasswordStrong("strongpassword")); // true
        System.out.println(isPasswordStrong("weakpassword")); // false
    }
}