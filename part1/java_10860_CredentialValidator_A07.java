public class java_10860_CredentialValidator_A07 {

    public static boolean validateCredentials(String username, String password) {
        // Assume valid credentials here
        String validUsername = "test";
        String validPassword = "password";

        // Check if provided credentials match valid credentials
        if (username.equals(validUsername) && password.equals(validPassword)) {
            System.out.println("Valid credentials!");
            return true;
        } else {
            System.out.println("Invalid credentials!");
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validateCredentials method
        validateCredentials("test", "password");
        validateCredentials("wrong", "password");
        validateCredentials("test", "wrong");
        validateCredentials("wrong", "wrong");
    }
}