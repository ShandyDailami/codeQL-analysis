public class java_39340_CredentialValidator_A08 {
    // hardcoded pattern for testing purposes
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public static boolean validate(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        // test the validator
        System.out.println(validate("test")); // should print true
        System.out.println(validate("test123")); // should print false
        System.out.println(validate("Test")); // should print false
        System.out.println(validate("Test123")); // should print false
        System.out.println(validate("Test123@")); // should print false
        System.out.println(validate("Test123@abc")); // should print true
    }
}