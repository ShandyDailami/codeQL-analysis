import java.util.Base64;

public class java_00945_CredentialValidator_A07 {
    // Expected credentials
    private static final String EXPECTED_USERNAME = "user";
    private static final String EXPECTED_PASSWORD = "pass";

    public static void main(String[] args) {
        // Actual credentials
        String actualUsername = "user";
        String actualPassword = "pass";

        validate(actualUsername, actualPassword);
    }

    public static void validate(String username, String password) {
        // Decode base64 to get username and password
        byte[] decodedBytes = Base64.getDecoder().decode(username);
        String decodedUsername = new String(decodedBytes);

        decodedBytes = Base64.getDecoder().decode(password);
        String decodedPassword = new String(decodedBytes);

        // Validate credentials
        if (decodedUsername.equals(EXPECTED_USERNAME) && decodedPassword.equals(EXPECTED_PASSWORD)) {
            System.out.println("Credentials are correct.");
        } else {
            System.out.println("Credentials are incorrect.");
        }
    }
}