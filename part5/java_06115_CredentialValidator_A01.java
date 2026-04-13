public class java_06115_CredentialValidator_A01 {

    // In a real-world scenario, you'd use a more complex object for storing credentials,
    // but for the sake of simplicity, we'll use a simple string.
    private static String correctUsername = "user";
    private static String correctPassword = "password";

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        return username.equals(correctUsername) && password.equals(correctPassword);
    }

    public static void main(String[] args) {
        // This is a test to validate the username and password.
        // In a real-world scenario, this would likely come from a user input.
        boolean isValid = validate("user", "password");
        System.out.println("Is valid: " + isValid);
    }
}