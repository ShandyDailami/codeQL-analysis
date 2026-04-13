public class java_26506_CredentialValidator_A07 {

    // Simulate a database
    private static String validUsername = "admin";
    private static String validPassword = "password";

    // Credentials validation method
    public static boolean validate(String username, String password) {
        // Simulate database query
        if (username.equals(validUsername) && password.equals(validPassword)) {
            System.out.println("Authentication successful!");
            return true;
        } else {
            System.out.println("Authentication failed!");
            return false;
        }
    }

    public static void main(String[] args) {
        // Testing
        CredentialValidator validator = new CredentialValidator();
        validator.validate("admin", "password");
    }

}