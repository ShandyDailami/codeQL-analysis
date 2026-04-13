public class java_13150_CredentialValidator_A03 {

    // This is the hard-coded password pattern we'll be checking against.
    private static final String VALID_PASSWORD_PATTERN = "^[a-zA-Z0-9]+$";

    public static boolean validate(String password) {
        return password.matches(VALID_PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        // Test the validator with some passwords
        System.out.println(validate("test123")); // should print true
        System.out.println(validate("test1234")); // should print false
        System.out.println(validate("test")); // should print false
    }
}