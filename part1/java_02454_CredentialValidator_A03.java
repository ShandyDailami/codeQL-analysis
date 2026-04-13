public class java_02454_CredentialValidator_A03 {
    // Define a static array to store user credentials
    private static String[] credentials = {"admin", "password"};

    // Define a method to validate the credentials
    public static boolean validateCredentials(String username, String password) {
        // Check if the provided username and password match the stored ones
        return (username.equals(credentials[0) && password.equals(credentials[1]));
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test the validateCredentials method
        System.out.println(validateCredentials("admin", "password"));  // Should print: true
        System.out.println(validateCredentials("admin", "wrongpassword"));  // Should print: false
        System.out.println(validateCredentials("wrongusername", "password"));  // Should print: false
    }
}