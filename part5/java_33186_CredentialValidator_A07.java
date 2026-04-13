public class java_33186_CredentialValidator_A07 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validate method
        System.out.println(validate("admin", "password")); // true
        System.out.println(validate("test", "test")); // false
    }
}