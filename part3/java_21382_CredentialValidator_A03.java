import java.util.Base64;

public class java_21382_CredentialValidator_A03 {
    public static boolean validate(String username, String password) {
        // In a real-world application, you would need to connect to a database to retrieve
        // the actual credentials and compare them to the provided ones.
        // This is just a placeholder for demonstration purposes.
        String expectedUsername = "admin";
        String expectedPassword = "password";

        // Convert password to Base64 to avoid storing plain text passwords
        String base64Credentials = Base64.getEncoder().encodeToString((expectedUsername + ":" + expectedPassword).getBytes());

        // Compare the provided credentials with the expected credentials
        return base64Credentials.equals(username + ":" + password);
    }
}