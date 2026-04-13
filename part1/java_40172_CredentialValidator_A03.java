public class java_40172_CredentialValidator_A03 {

    // This is a simple username and password.
    // In a real application, you would use hashing and
    // a secure method (like bcrypt) to store the actual password.
    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    public static boolean validate(String username, String password) {
        if (username.equals(EXPECTED_USERNAME) && password.equals(EXPECTED_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Trying out the validator with some credentials
        System.out.println(validate("admin", "password")); // should print true
        System.out.println(validate("wrong", "password")); // should print false
        System.out.println(validate("admin", "wrong")); // should print false
    }
}