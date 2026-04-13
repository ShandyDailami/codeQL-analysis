public class java_11056_CredentialValidator_A01 {

    // Hard-coded credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    // Method to validate credentials
    public static boolean validate(String username, String password) {
        if (username != null && username.equals(USERNAME) && password != null && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method to test the validate method
    public static void main(String[] args) {
        System.out.println(validate("user", "password"));  // Expected output: true
        System.out.println(validate("wrong", "username"));  // Expected output: false
        System.out.println(validate("user", "wrong"));  // Expected output: false
    }
}