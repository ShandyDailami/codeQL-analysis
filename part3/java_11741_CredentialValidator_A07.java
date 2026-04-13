import java.util.Base64;
import java.util.Optional;

public class java_11741_CredentialValidator_A07 {

    public Optional<String> validateCredentials(String encodedUsername, String encodedPassword, String expectedPassword) {
        String decodedUsername = new String(Base64.getDecoder().decode(encodedUsername));
        String decodedPassword = new String(Base64.getDecoder().decode(encodedPassword));
        
        if (decodedUsername.equals("admin") && decodedPassword.equals(expectedPassword)) {
            return Optional.empty(); // Credentials are valid
        } else {
            return Optional.of("Invalid username or password"); // Credentials are invalid
        }
    }

    public static void main(String[] args) {
        String encodedUsername = "YWJjZGVmZw=="; // "admin" in base64
        String encodedPassword = "YWRtaW4="; // "password" in base64
        String expectedPassword = "password";

        CredentialValidator validator = new CredentialValidator();
        Optional<String> result = validator.validateCredentials(encodedUsername, encodedPassword, expectedPassword);

        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Credentials are valid");
        }
    }
}