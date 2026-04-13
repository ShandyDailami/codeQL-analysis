public class java_38756_CredentialValidator_A07 {

    // Define a set of valid credentials
    private static String validUsername = "admin";
    private static String validPassword = "password";

    // This is the method to validate the username and password
    public static boolean validate(String username, String password) {
        return username.equals(validUsername) && password.equals(validPassword);
    }

    public static void main(String[] args) {
        // Test the validate method
        boolean isValid = validate("admin", "password");
        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}