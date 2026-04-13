public class java_41292_CredentialValidator_A08 {
    public static boolean validate(String username, String password) {
        // Hard-coded values for comparison
        String hardCodedUsername = "testuser";
        String hardCodedPassword = "password";

        // Validate credentials
        if (username.equals(hardCodedUsername) && password.equals(hardCodedPassword)) {
            System.out.println("Credentials are valid.");
            return true;
        } else {
            System.out.println("Invalid credentials.");
            return false;
        }
    }

    public static void main(String[] args) {
        // Username and password for testing
        String hardCodedUsername = "testuser";
        String hardCodedPassword = "password";

        // Test the validate method
        validate(hardCodedUsername, hardCodedPassword);
    }
}