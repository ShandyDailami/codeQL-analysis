import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_13064_CredentialValidator_A07 {

    // A simple data store for validated credentials
    private Map<String, String> validatedCredentials = new HashMap<>();

    public void validateCredentials(String username, String password) {
        // This is a dummy validation, in a real scenario you would use a database or other storage
        // to check if the username and password match what is stored in the database
        String expectedPassword = validatedCredentials.get(username);

        if (expectedPassword != null) {
            byte[] decodedBytes = Base64.getDecoder().decode(expectedPassword);
            String expectedPasswordDecoded = new String(decodedBytes);

            if (expectedPasswordDecoded.equals(password)) {
                System.out.println("Credentials are valid.");
            } else {
                System.out.println("Credentials are invalid.");
            }
        } else {
            System.out.println("Username not found.");
        }
    }

    public void saveExpectedPassword(String username, String password) {
        byte[] bytes = password.getBytes();
        String encodedPassword = Base64.getEncoder().encodeToString(bytes);

        validatedCredentials.put(username, encodedPassword);
    }
}