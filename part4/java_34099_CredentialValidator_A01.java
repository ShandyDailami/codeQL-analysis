public class java_34099_CredentialValidator_A01 {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static boolean isValidPassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        // Testing
        System.out.println(isValidPassword("password")); // should return true
        System.out.println(isValidPassword("weakpassword")); // should return false
    }
}