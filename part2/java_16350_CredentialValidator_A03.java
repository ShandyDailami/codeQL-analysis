public class java_16350_CredentialValidator_A03 {

    private static final String WEAK_PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,16}$";

    public static boolean isPasswordStrong(String password) {
        return password.matches(WEAK_PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        System.out.println(isPasswordStrong("Password@123")); // returns true
        System.out.println(isPasswordStrong("Password")); // returns false
    }
}