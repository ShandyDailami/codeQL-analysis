public class java_07381_CredentialValidator_A01 {
    // Hardcoded password for simplicity
    private static final String PASSWORD = "password";

    public static boolean validate(String userName, String password) {
        // If userName and password match the hardcoded ones, return true
        // Otherwise, return false
        if (userName.equals("user") && password.equals(PASSWORD)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the validate method
        System.out.println(validate("user", "password")); // true
        System.out.println(validate("user", "wrongPassword")); // false
        System.out.println(validate("wrongUser", "password")); // false
        System.out.println(validate("wrongUser", "wrongPassword")); // false
    }
}