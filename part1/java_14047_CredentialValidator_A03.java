public class java_14047_CredentialValidator_A03 {
    private static final String CORRECT_USERNAME = "test";
    private static final String CORRECT_PASSWORD = "password";

    public static boolean isValid(String username, String password) {
        return username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD);
    }

    public static void main(String[] args) {
        System.out.println(isValid("test", "password")); // Prints true
        System.out.println(isValid("wrong", "password")); // Prints false
   .
.
.
    // Prints the expected results in the console
    }
}