import java.util.Base64;

public class java_26349_CredentialValidator_A03 {

    // Storing the mock username and password
    private static final String MOCK_USERNAME = "mockUser";
    private static final String MOCK_PASSWORD = "mockPass";

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Decoding the base64 password
        byte[] decodedPassword = Base64.getDecoder().decode(password);

        // Checking if the provided username and password match the mock ones
        return username.equals(MOCK_USERNAME) && password.equals(MOCK_PASSWORD);
    }
}